/**
 * 
 */
package com.chahyadis.jwt.action;

import com.chahyadis.jwt.interfaces.IssuerKey;

/**Proses<br/>
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public class IssuerKeySetup implements IssuerKey {

	/* (non-Javadoc)
	 * @see com.chahyadis.jwt.interfaces.IssuerKey#appsName()
	 */
	public String[] appsName() {
		// TODO Auto-generated method stub
		return new String[] {"chahyadis client project"};
	}
	
	
}
