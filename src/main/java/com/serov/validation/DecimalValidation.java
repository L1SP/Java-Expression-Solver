package com.serov.validation;

import java.util.ArrayList;

import com.serov.exceptions.InvalidCharacterException;
import com.serov.partition.ExpressionPart;

/**
 * Validator implementation for decimal numbers
 * @author n.a.serov
 */
public class DecimalValidation implements TokenValidation {
	
	/**
	 * Default constructor without parameters
	 */
	public DecimalValidation() {}

	/**
     * Validate the given expression part is valid at current index
     * @param currentExp ArrayList of current expression parts
     * @param currentIndex index of current expression part in currentExp ArrayList
     * @return returns true if the given expression part at current index is valid, otherwise returns false
     */
    @Override
    public boolean performValidation(ArrayList < ExpressionPart > currentExp, int currentIndex) {
        boolean result = true;
        String currentExpression = currentExp.get(currentIndex).getExpressionPart();
        int countDecimal = 0;
        boolean flag = false;
        for (int j = 0; j < currentExpression.length(); j++) {
            if (currentExpression.charAt(j) == '.') {
                countDecimal++;
                flag = true;
            } else {
                flag = false;
            }
        }
        if (flag) {
            result = false;
            throw new InvalidCharacterException("No digits found after a decimal point: " + currentExpression);
        }
        if (countDecimal == 2) {
            result = false;
            throw new InvalidCharacterException("More than one decimal point in a single number: " + currentExpression);
        }
        return result;
    }
}