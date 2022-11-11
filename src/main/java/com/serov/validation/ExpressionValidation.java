package com.serov.validation;

import java.util.ArrayList;
import java.util.Stack;

import com.serov.exceptions.InvalidCharacterException;
import com.serov.partition.ExpressionPart;

/**
 * Validator implementation for expressions
 * @author n.a.serov
 */
public class ExpressionValidation {
	
	/**
	 * Default constructor without parameters
	 */
	public ExpressionValidation() {}

    /**
     * Checks if the given expression parts are valid
     * @param expressionParts expression parts to be checked if they're valid
     * @return returns true if the given expression is valid, otherwise returns false
     */
    public static boolean isValid(ArrayList < ExpressionPart > expressionParts) {
        boolean result = true;
        result = areParenthesesValid(expressionParts);
        if (!result) {
            return false;
        }
        for (int i = 0; i < expressionParts.size(); i++) {
            String current = expressionParts.get(i).getExpressionPart();
            TokenValidation tokenValidation = TokenValidationGenerator.getCurrentTokenValidation(current);
            result = tokenValidation.performValidation(expressionParts, i);
            if (!result) {
                return false;
            }
        }
        return result;
    }

    /**
     * Checks if parentheses are valid in given expression parts
     * @param expressionParts expression parts to be checked if parentheses match
     * @return returns true if parentheses are valid, otherwise returns false
     */
    private static boolean areParenthesesValid(ArrayList < ExpressionPart > expressionParts) {
        boolean result = true;
        Stack < String > parentheses = new Stack < String > ();
        for (int i = 0; i < expressionParts.size(); i++) {
            String currentExpression = expressionParts.get(i).getExpressionPart();
            if (currentExpression == "(") {
                parentheses.push("(");
            } else if (currentExpression == ")") {
                if (!parentheses.empty()) {
                    parentheses.pop();
                } else {
                    result = false;
                    throw new InvalidCharacterException("Parentheses mismatch");
                }
            }
        }
        if (!parentheses.empty()) {
            result = false;
            throw new InvalidCharacterException("Parentheses mismatch");
        }
        return result;
    }
}