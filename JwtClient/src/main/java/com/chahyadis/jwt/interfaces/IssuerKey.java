/**
 * 
 */
package com.chahyadis.jwt.interfaces;

/**
 * IssuerKey<br>
 * nama aplikasi.
 * 
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public abstract interface IssuerKey {
	/**
	 * appName<br/>
	 * Berupa identitas project yang akan divalidasi oleh server.
	 * 
	 * @return {@link String}
	 */
	abstract String appName();
}
