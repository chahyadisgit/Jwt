package com.chahyadis.jwt.action;

import com.chahyadis.jwt.interfaces.IssuerKey;

/**
 * IssuerSetup<br/>
 * Tuliskan saja nama aplikasi-nya disini untuk di jadikan identity di server.
 * 
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public class IssuerKeySetup implements IssuerKey {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.chahyadis.jwt.interfaces.IssuerKey#appName()
	 */
	public String appName() {
		return "USER_MANAGEMENT";
	}

}
