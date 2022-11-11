package com.serov.exceptions;

/**
 * Invalid character exception class
 * @author n.a.serov
 */
@SuppressWarnings("serial")
public class InvalidCharacterException extends RuntimeException {
	
	/**
	 * Throws a InvalidCharacterException with a given message
	 * @param msg message to be printed
	 */
	public InvalidCharacterException(String msg) {
        super(msg);
    }
}
