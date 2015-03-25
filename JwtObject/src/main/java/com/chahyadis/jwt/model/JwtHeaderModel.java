/**
 * 
 */
package com.chahyadis.jwt.model;

/**
 * HeaderModel.
 * 
 * @author Surya Chahyadi
 * @since March 24th, 2015
 * @version 1.0
 */
public class JwtHeaderModel {
	private String typ;
	private String alg;

	/**
	 * @return the typ
	 */
	public String getTyp() {
		return typ;
	}

	/**
	 * @param typ
	 *            the typ to set
	 */
	public void setTyp(String typ) {
		this.typ = typ;
	}

	/**
	 * @return the alg
	 */
	public String getAlg() {
		return alg;
	}

	/**
	 * @param alg
	 *            the alg to set
	 */
	public void setAlg(String alg) {
		this.alg = alg;
	}

}
