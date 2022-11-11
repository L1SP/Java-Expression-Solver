package com.serov.exceptions;

/**
 * Null operator exception class
 * @author n.a.serov
 */
@SuppressWarnings("serial")
public class NullOperatorException extends RuntimeException {
	
	/**
	 * Throws a NullOperatorException with a given message
	 * @param msg message to be printed
	 */
    public NullOperatorException(String msg) {
        super(msg);
    }
}