/**
 * 
 */
package com.ccea.persistence.exceptions;

/**
 * @author abuayyub
 *
 */
public class DataStoreException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7849042525668181874L;

	/**
	 * 
	 */
	public DataStoreException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DataStoreException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DataStoreException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DataStoreException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DataStoreException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
