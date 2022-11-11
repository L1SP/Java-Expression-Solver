package com.serov.validation;

import com.serov.data.ExpressionData;

/**
 * A generator for operator and decimal validators
 * @author n.a.serov
 */
public class TokenValidationGenerator {
	
	/**
	 * Default constructor without parameters
	 */
	public TokenValidationGenerator() {}
	
	/**
	 * Returns operator or decimal validator based on given string
	 * @param tokenValidation given string to determine if it's decimal number or an operator
	 * @return returns operator or decimal validator based on given string
	 */
	 public static TokenValidation getCurrentTokenValidation(String tokenValidation) {
	        if(ExpressionData.isOperator(tokenValidation)) {
	            return new OperatorValidation();
	        }
	        return new DecimalValidation();
	 }
}
