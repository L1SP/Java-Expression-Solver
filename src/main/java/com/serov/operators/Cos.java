package com.serov.operators;

import com.serov.exceptions.InvalidOperandException;

/**
 * Cos operator implementation
 * @author Николай
 */
public class Cos implements Operator {

	/**
	 * Default constructor without parameters
	 */
	public Cos() {}
	
    /**
     * Overridden doCalculation method that returns the cos of given angle
     * @param operands an array of one operand to find the cos
     * @return returns the cos of given angle
     */
    @Override
    public Double doCalculation(Double...operands) throws InvalidOperandException {
        if (operands.length != 1) {
            throw new InvalidOperandException("Got more than one operand: " + operands.length);
        }
        return Math.cos(Math.toRadians(operands[0]));
    }

}