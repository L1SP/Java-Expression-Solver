package com.serov.operators;

import com.serov.exceptions.DivisionByZeroException;
import com.serov.exceptions.InvalidOperandException;

/**
 * Division operator implementation
 * @author Николай
 */
public class Division implements Operator {

	/**
	 * Default constructor without parameters
	 */
	public Division() {}
	
    /**
     * Overridden doCalculation method that performs the division of two operands and returns the result
     * @param operands an array of operands to perform the division, operands[0] is denominator, operands[1] is numerator
     * @return the division of the second and the first operands
     * @throws InvalidOperandException if the first operand is equal to 0
     */
    @Override
    public Double doCalculation(Double...operands) throws InvalidOperandException {
        if (operands.length != 2) {
            throw new InvalidOperandException("Got more than two operands: " + operands.length);
        }
        if (operands[0] == Math.floor(operands[0])) {
            double second = operands[0];
            int integerResult = (int) second;
            if (integerResult == 0) {
                throw new DivisionByZeroException("Division by zero");
            }
        }
        return operands[1] / operands[0];
    }
}