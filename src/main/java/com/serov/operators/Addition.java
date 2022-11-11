package com.serov.operators;

import com.serov.exceptions.InvalidOperandException;

/**
 * Addition operator implementation
 * @author Николай
 */
public class Addition implements Operator {

	/**
	 * Default constructor without parameters
	 */
	public Addition() {}
	
    /**
     * Overridden doCalculation method that performs the addition of two operands and returns the result
     * @param operands an array of operands to perform the addition
     * @return returns the sum of two operands
     */
    @Override
    public Double doCalculation(Double...operands) throws InvalidOperandException {
        if (operands.length != 2) {
            throw new InvalidOperandException("Got more than two operands: " + operands.length);
        }
        return operands[0] + operands[1];
    }
}