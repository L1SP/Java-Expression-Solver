package com.serov.operators;

import com.serov.exceptions.InvalidOperandException;

/**
 * Multiplication operator implementation
 * @author Николай
 */
public class Multiplication implements Operator {

	/**
	 * Default constructor without parameters
	 */
	public Multiplication() {}
	
    /**
     * Overridden doCalculation method that performs the multiplication of two operands and returns the result
     * @param operands an array of operands to perform the multiplication
     * @return returns the multiplication of two operands
     */
    @Override
    public Double doCalculation(Double...operands) throws InvalidOperandException {
        if (operands.length != 2) {
            throw new InvalidOperandException("Got more than two operands: " + operands.length);
        }
        return operands[0] * operands[1];
    }
}