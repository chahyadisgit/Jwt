/**
 * 
 */
package com.chahyadis.jwt.constantas;

/**
 * Constanta.
 * 
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public interface Constanta {
	static final int SUCCESS_STATUS = 0;
	static final int FAILED_STATUS = 1;

	// HTTP RESPONSE STATUS CODE
	static final int CODE_SUCCESS = 200;
	static final int CODE_BAD_REQUEST = 400;
	static final int CODE_UNAUTHORIZED = 401;
	static final int CODE_FORBIDDEN = 403;
	static final int CODE_REQUEST_TIMEOUT = 408;
	static final int CODE_TOKEN_EXPIRED = 498;
	static final int CODE_TOKEN_REQUIRED = 499;
}
