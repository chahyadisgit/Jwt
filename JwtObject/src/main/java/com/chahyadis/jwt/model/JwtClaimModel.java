/**
 * 
 */
package com.chahyadis.jwt.model;

import java.util.Date;

/**
 * JwtClaimModel<br/>
 * claim model.
 * 
 * @author Surya Chahyadi
 * @since March 24th, 2015
 * @version 1.0
 */
public class JwtClaimModel extends BaseModel<JwtClaimModel> {
	private String sub;
	private String aud;
	private String nbf;
	private String qsh;
	private String iss;
	private String typ;
	private Date exp;
	private Date iat;
	private String jti;

	/**
	 * @return the sub
	 */
	public String getSub() {
		return sub;
	}

	/**
	 * @param sub
	 *            the sub to set
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}

	/**
	 * @return the aud
	 */
	public String getAud() {
		return aud;
	}

	/**
	 * @param aud
	 *            the aud to set
	 */
	public void setAud(String aud) {
		this.aud = aud;
	}

	/**
	 * @return the nbf
	 */
	public String getNbf() {
		return nbf;
	}

	/**
	 * @param nbf
	 *            the nbf to set
	 */
	public void setNbf(String nbf) {
		this.nbf = nbf;
	}

	/**
	 * @return the qsh
	 */
	public String getQsh() {
		return qsh;
	}

	/**
	 * @param qsh
	 *            the qsh to set
	 */
	public void setQsh(String qsh) {
		this.qsh = qsh;
	}

	/**
	 * @return the iss
	 */
	public String getIss() {
		return iss;
	}

	/**
	 * @param iss
	 *            the iss to set
	 */
	public void setIss(String iss) {
		this.iss = iss;
	}

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
	 * @return the exp
	 */
	public Date getExp() {
		return exp;
	}

	/**
	 * @param exp
	 *            the exp to set
	 */
	public void setExp(Date exp) {
		this.exp = exp;
	}

	/**
	 * @return the iat
	 */
	public Date getIat() {
		return iat;
	}

	/**
	 * @param iat
	 *            the iat to set
	 */
	public void setIat(Date iat) {
		this.iat = iat;
	}

	/**
	 * @return the jti
	 */
	public String getJti() {
		return jti;
	}

	/**
	 * @param jti
	 *            the jti to set
	 */
	public void setJti(String jti) {
		this.jti = jti;
	}

}
