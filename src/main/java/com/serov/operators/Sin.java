package com.serov.operators;

import com.serov.exceptions.InvalidOperandException;

/**
 * Sin operator implementation
 * @author Николай
 */
public class Sin implements Operator {

	/**
	 * Default constructor without parameters
	 */
	public Sin() {}
	
    /**
     * Overridden doCalculation method that returns the sin of given angle
     * @param operands an array of one operand to find the sin
     * @return returns the sin of given angle
     */
    @Override
    public Double doCalculation(Double...operands) throws InvalidOperandException {
        if (operands.length != 1) {
            throw new InvalidOperandException("Got more than one operand: " + operands.length);
        }
        return Math.sin(Math.toRadians(operands[0]));
    }
}