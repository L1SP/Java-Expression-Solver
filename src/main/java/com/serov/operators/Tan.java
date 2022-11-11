package com.serov.operators;

import com.serov.exceptions.InvalidOperandException;

/**
 * Tan operator implementation
 * @author Николай
 */
public class Tan implements Operator {

	/**
	 * Default constructor without parameters
	 */
	public Tan() {}
	
    /**
     * Overridden doCalculation method that returns the tan of given angle
     * @param operands an array of one operand to find the tan
     * @return returns the tan of given angle
     */
    @Override
    public Double doCalculation(Double...operands) throws InvalidOperandException {
        if (operands.length != 1) {
            throw new InvalidOperandException("Got more than one operand: " + operands.length);
        }
        return Math.tan(Math.toRadians(operands[0]));
    }
}