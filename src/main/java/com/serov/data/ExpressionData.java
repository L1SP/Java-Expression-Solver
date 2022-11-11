package com.serov.data;

/**
 * Unary and binary operators' methods implementation class
 * @author n.a.serov
 */
public class ExpressionData {
	
	/**
	 * Default constructor without parameters
	 */
	public ExpressionData() {}

    // Definition of unary operators(1 operand)
    private static String unaryOperators[] = {
        "sin",
        "cos",
        "tan"
    };

    // Definition of binary operators(2 operands)
    private static String binaryOperators[] = {
        "+",
        "-",
        "*",
        "/"
    };

    /**
     * Checks if a given operator is unary
     * @param operator operator to check if it's unary
     * @return returns true if operator is unary, returns false if operator is not unary
     */
    public static boolean isUnary(String operator) {
        for (int i = 0; i < unaryOperators.length; i++) {
            if (unaryOperators[i].equals(operator)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given operator is binary
     * @param operator operator to check if it's binary
     * @return returns true if operator is binary, returns false if operator is not binary
     */
    public static boolean isBinary(String operator) {
        for (int i = 0; i < binaryOperators.length; i++) {
            if (binaryOperators[i].equals(operator)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a given string is an operator
     * @param operator string to check if it's an operator
     * @return returns true if the given string is an operator, returns false if the given string is not an operator
     */
    public static boolean isOperator(String operator) {
        for (int i = 0; i < unaryOperators.length; i++) {
            if (unaryOperators[i].equals(operator)) {
                return true;
            }
        }
        for (int i = 0; i < binaryOperators.length; i++) {
            if (binaryOperators[i].equals(operator)) {
                return true;
            }
        }
        return false;
    }
}