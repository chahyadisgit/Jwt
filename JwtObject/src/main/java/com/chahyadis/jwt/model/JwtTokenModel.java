/**
 * 
 */
package com.chahyadis.jwt.model;

/**
 * JwtTokenModel<br/>
 * Token model.
 * 
 * @author Surya Chahyadi
 * @since March 25th, 2015
 * @version 1.0
 */
public class JwtTokenModel {
	private String signature;
	private JwtHeaderModel jwtHeaderModel;
	private JwtClaimModel jwtClaimModel;

	/**
	 * JwtTokenModel<br/>
	 * Constructor.
	 * 
	 * @param signature
	 *            {@link String}
	 * @param jwtHeaderModel
	 *            {@link JwtHeaderModel}
	 * @param jwtClaimModel
	 *            {@link JwtClaimModel}
	 */
	public JwtTokenModel(String signature, JwtHeaderModel jwtHeaderModel,
			JwtClaimModel jwtClaimModel) {
		this.signature = signature;
		this.jwtHeaderModel = jwtHeaderModel;
		this.jwtClaimModel = jwtClaimModel;
	}

	/**
	 * 
	 */
	public JwtTokenModel() {
	}

	/**
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * @param signature
	 *            the signature to set
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * @return the jwtHeaderModel
	 */
	public JwtHeaderModel getJwtHeaderModel() {
		return jwtHeaderModel;
	}

	/**
	 * @param jwtHeaderModel
	 *            the jwtHeaderModel to set
	 */
	public void setJwtHeaderModel(JwtHeaderModel jwtHeaderModel) {
		this.jwtHeaderModel = jwtHeaderModel;
	}

	/**
	 * @return the jwtClaimModel
	 */
	public JwtClaimModel getJwtClaimModel() {
		return jwtClaimModel;
	}

	/**
	 * @param jwtClaimModel
	 *            the jwtClaimModel to set
	 */
	public void setJwtClaimModel(JwtClaimModel jwtClaimModel) {
		this.jwtClaimModel = jwtClaimModel;
	}

}
