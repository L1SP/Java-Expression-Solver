package com.serov.operators;

import com.serov.exceptions.InvalidOperandException;

/**
 * Substraction operator implementation
 * @author Николай
 */
public class Substraction implements Operator {

	/**
	 * Default constructor without parameters
	 */
	public Substraction() {}
	
    /**
     * Overridden doCalculation method that performs the substraction of two operands and returns the result
     * @param operands an array of operands to perform the substraction, operands[0] is subtrahend, operands[1] is subtractor
     * @return the substraction of the second and the first operands
     */
    @Override
    public Double doCalculation(Double...operands) throws InvalidOperandException {
        if (operands.length != 2) {
            throw new InvalidOperandException("Got more than two operands: " + operands.length);
        }
        return operands[1] - operands[0];
    }
}