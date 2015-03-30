package com.chahyadis.jwt.model;

/**
 * JwtTokenModel<br/>
 * Token model.
 * 
 * @author Surya Chahyadi
 * @since March 25th, 2015
 * @version 1.0
 */
public class JwtTokenModel extends BaseModel<JwtTokenModel> {
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
	 * getSignature.
	 * 
	 * @return the signature {@link String}<br/>
	 *         token signature.
	 */
	public String getSignature() {
		return signature;
	}

	/**
	 * setSignature<br/>
	 * token signature.
	 * 
	 * @param signature
	 *            {@link String} the signature to set.
	 */
	public void setSignature(String signature) {
		this.signature = signature;
	}

	/**
	 * getJwtHeaderModel.
	 * 
	 * @return the jwtHeaderModel {@link JwtHeaderModel}
	 */
	public JwtHeaderModel getJwtHeaderModel() {
		return jwtHeaderModel;
	}

	/**
	 * setJwtHeaderModel.
	 * 
	 * @param jwtHeaderModel
	 *            {@link JwtHeaderModel} the jwtHeaderModel to set.
	 */
	public void setJwtHeaderModel(JwtHeaderModel jwtHeaderModel) {
		this.jwtHeaderModel = jwtHeaderModel;
	}

	/**
	 * getJwtClaimModel.
	 * 
	 * @return the jwtClaimModel {@link JwtClaimModel}.
	 */
	public JwtClaimModel getJwtClaimModel() {
		return jwtClaimModel;
	}

	/**
	 * setJwtClaimModel
	 * 
	 * @param jwtClaimModel
	 *            {@link JwtClaimModel} the jwtClaimModel to set.
	 */
	public void setJwtClaimModel(JwtClaimModel jwtClaimModel) {
		this.jwtClaimModel = jwtClaimModel;
	}

}
