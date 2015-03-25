/**
 * 
 */
package com.chahyadis.jwt.model;

/**
 * UrlContextPathModel.
 * 
 * @author Surya Chahyadi
 * @since March 24th, 2015
 * @version 1.0
 */
public class UrlContextPathModel {
	private Long expiresAt;
	private String key;
	private String sharedSecret;
	private String method;
	private String baseUrl;
	private String contextPath;
	private String apiPath;

	/**
	 * @param expiresAt
	 *            {@link Long}
	 * @param key
	 *            {@link String}
	 * @param sharedSecret
	 *            {@link String}
	 * @param method
	 *            {@link String}
	 * @param baseUrl
	 *            {@link String}
	 * @param contextPath
	 *            {@link String}
	 * @param apiPath
	 *            {@link String}
	 */
	public UrlContextPathModel(Long expiresAt, String key, String sharedSecret,
			String method, String baseUrl, String contextPath, String apiPath) {
		super();
		this.expiresAt = expiresAt;
		this.key = key;
		this.sharedSecret = sharedSecret;
		this.method = method;
		this.baseUrl = baseUrl;
		this.contextPath = contextPath;
		this.apiPath = apiPath;
	}

	/**
	 * UrlContextPathModel.
	 */
	public UrlContextPathModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the expiresAt
	 */
	public Long getExpiresAt() {
		return expiresAt;
	}

	/**
	 * @param expiresAt
	 *            the expiresAt to set
	 */
	public void setExpiresAt(Long expiresAt) {
		this.expiresAt = expiresAt;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the sharedSecret
	 */
	public String getSharedSecret() {
		return sharedSecret;
	}

	/**
	 * @param sharedSecret
	 *            the sharedSecret to set
	 */
	public void setSharedSecret(String sharedSecret) {
		this.sharedSecret = sharedSecret;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method
	 *            the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the baseUrl
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * @param baseUrl
	 *            the baseUrl to set
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * @return the contextPath
	 */
	public String getContextPath() {
		return contextPath;
	}

	/**
	 * @param contextPath
	 *            the contextPath to set
	 */
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	/**
	 * @return the apiPath
	 */
	public String getApiPath() {
		return apiPath;
	}

	/**
	 * @param apiPath
	 *            the apiPath to set
	 */
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

}
