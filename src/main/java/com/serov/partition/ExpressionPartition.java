package com.serov.partition;

import java.util.ArrayList;

import com.serov.data.ExpressionData;
import com.serov.exceptions.InvalidCharacterException;

/**
 * ExpressionPartition class implementation
 * @author n.a.serov
 */
public class ExpressionPartition {

    // ArrayList to store the expression parts
    private ArrayList < ExpressionPart > expressionParts;

    // The given expression string
    private String expression;

    /**
     * Constructor with given string, sets the expression with the given expression, creates a new ArrayList instance of expression parts
     * @param expression the given expression to set the local variable
     */
    public ExpressionPartition(String expression) {
        this.expression = expression;
        expressionParts = new ArrayList < ExpressionPart > ();
    }

    /**
     * Splits expression into expression parts
     */
    public void splitIntoExpressionParts() {
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar == '(') {
                expressionParts.add(new ExpressionPart("("));
            } else if (currentChar == ')') {
                expressionParts.add(new ExpressionPart(")"));
            } else if (currentChar == ' ') {
                continue;
            } else if (Character.isDigit(currentChar) || currentChar == '.') {
                StringBuffer currentNumber = new StringBuffer();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    currentNumber.append(expression.charAt(i++));
                }
                if (i < expression.length()) {
                    i--;
                }
                expressionParts.add(new ExpressionPart(currentNumber.toString()));
                continue;
            } else if (Character.isAlphabetic(currentChar)) {
                StringBuffer currentOperator = new StringBuffer();
                while (i < expression.length() && (Character.isAlphabetic(expression.charAt(i)))) {
                    currentOperator.append(expression.charAt(i++));
                }
                if (i < expression.length()) {
                    i--;
                }
                String currentOp = currentOperator.toString();
                if (ExpressionData.isOperator(currentOp)) {
                    expressionParts.add(new ExpressionPart(currentOp));
                } else {
                    throw new InvalidCharacterException("Found invalid character while parsing the expression: " + currentOp);
                }
                continue;
            } else {
                String currentOp = Character.toString(currentChar);
                if (ExpressionData.isOperator(currentOp)) {
                    expressionParts.add(new ExpressionPart(currentOp));
                } else {
                    throw new InvalidCharacterException("Found invalid character while parsing the expression: " + currentOp);
                }
            }
        }
    }

    /**
     * Returns the expression parts
     * @return returns the expression parts
     */
    public ArrayList < ExpressionPart > getExpressionParts() {
        return expressionParts;
    }
}