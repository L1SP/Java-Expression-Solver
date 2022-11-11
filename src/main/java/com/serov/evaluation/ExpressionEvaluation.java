package com.serov.evaluation;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

import com.serov.data.ExpressionData;
import com.serov.exceptions.InvalidOperandException;
import com.serov.exceptions.NullOperatorException;
import com.serov.operators.Operator;
import com.serov.operators.OperatorGenerator;
import com.serov.partition.ExpressionPart;


/**
 * Expression evaluation implementation class
 * @author n.a.serov
 */
public class ExpressionEvaluation {

    private Stack < Double > values;
    private Stack < String > expressionOperators;

    /**
     * Default constructor that creates 2 stacks for parsing the expression string
     */
    public ExpressionEvaluation() {
        values = new Stack < Double > ();
        expressionOperators = new Stack < String > ();
    }
    
    /**
     * Evaluation implementation, runs in a loop till the end of the given expression parts ArrayList
     * @param expressionParts an ArrayList of given expression parts
     * @return returns the evaluated expression part
     */
    public ExpressionPart evaluate(ArrayList < ExpressionPart > expressionParts) {
        for (int i = 0; i < expressionParts.size(); i++) {
            String currentExpression = expressionParts.get(i).getExpressionPart().trim();
            if (currentExpression.equals("(")) {
                expressionOperators.push(currentExpression);
            } else if (currentExpression.equals(")")) {
                while (!expressionOperators.peek().equals("(")) {
                    try {
                        calculate();
                    } catch (NullOperatorException e) {
                        e.getMessage();
                    }
                }
                expressionOperators.pop();
            } else if (!ExpressionData.isOperator(currentExpression)) {
                values.push(Double.parseDouble(currentExpression));
            } else if (currentExpression.equals("-") && (i == 0 || (ExpressionData.isOperator(expressionParts.get(i - 1).getExpressionPart()) || expressionParts.get(i - 1).getExpressionPart() == "("))) {
                Double negativeValue = Double.parseDouble(expressionParts.get(i + 1).getExpressionPart());
                negativeValue = -negativeValue;
                values.push(negativeValue);
                i = i + 1;
            } else {
                while (!expressionOperators.empty() && precedence(currentExpression, expressionOperators.peek())) {
                    try {
                        calculate();
                    } catch (NullOperatorException e) {
                        e.getMessage();
                    }
                }
                expressionOperators.push(currentExpression);
            }
        }
        while (!expressionOperators.empty()) {
            try {
                calculate();
            } catch (NullOperatorException e) {
                e.getMessage();
            }
        }
        try {
            return (new ExpressionPart(String.valueOf(values.pop())));
        } catch (EmptyStackException e) {
            throw new NullOperatorException("Failed to parse operators");
        }
    }

    /**
     * Operator Comparator that returns if the second operator has higher precedence
     * @param first the first operator to compare
     * @param second the second operator to compare
     * @return returns if the first operator has higher precedence
     */
    private boolean precedence(String first, String second) {
        if (second.equals("(") || second.equals("(")) {
            return false;
        }
        if ((first.equals("*") || first.equals("/")) && (second.equals("+") || second.equals("-"))) {
            return false;
        }
        if (ExpressionData.isUnary(first)) {
            return false;
        }
        return true;
    }

    /**
     * The method that performs the calculations
     * @throws NullOperatorException if the given operator is not defined or if there're >1 operators
     */
    private void calculate() throws NullOperatorException {
        String currentOp = expressionOperators.pop();
        Operator currentOperator = OperatorGenerator.getOperator(currentOp);
        if (currentOperator == null) {
            throw new NullOperatorException("No such operator defined: " + currentOp);
        }
        if (ExpressionData.isUnary(currentOp)) {
            try {
                values.push(currentOperator.doCalculation(values.pop()));
            } catch (InvalidOperandException e) {
                e.getMessage();
            }
        } else if (ExpressionData.isBinary(currentOp)) {
            try {
                values.push(currentOperator.doCalculation(values.pop(), values.pop()));
            } catch (InvalidOperandException e) {
                e.getMessage();
            } catch (EmptyStackException e) {
                throw new NullOperatorException("Failed to parse operators");
            }
        }
    }
}