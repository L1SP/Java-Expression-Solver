package com.serov.operators;

/**
 * A generator for operators
 * @author n.a.serov
 */
public class OperatorGenerator {

	/**
	 * Default constructor without parameters
	 */
	public OperatorGenerator() {}
	
    /**
     * Returns the operator class instance if it's defined
     * @param operator an operator to be matched with defined classes
     * @return returns the operator class instance if it's defined
     */
    public static Operator getOperator(String operator) {
        if (operator.equals("+")) {
            return new Addition();
        } else if (operator.equals("-")) {
            return new Substraction();
        } else if (operator.equals("*")) {
            return new Multiplication();
        } else if (operator.equals("/")) {
            return new Division();
        } else if (operator.equals("sin")) {
            return new Sin();
        } else if (operator.equals("cos")) {
            return new Cos();
        } else if (operator.equals("tan")) {
            return new Tan();
        } else {
            return null;
        }
    }
}