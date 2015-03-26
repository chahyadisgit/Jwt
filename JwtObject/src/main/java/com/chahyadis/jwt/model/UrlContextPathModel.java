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
	 * UrlContextPathModel.
	 * 
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
	}

	/**
	 * getExpiresAt.
	 * 
	 * @return the expiresAt<br/>
	 *         Expiration time.
	 */
	public Long getExpiresAt() {
		return expiresAt;
	}

	/**
	 * setExpiresAt.
	 * 
	 * @param expiresAt
	 *            {@link Long}<br/>
	 *            the expiresAt to set.
	 */
	public void setExpiresAt(Long expiresAt) {
		this.expiresAt = expiresAt;
	}

	/**
	 * getKey.
	 * 
	 * @return the key<br/>
	 *         key of application.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * setKey.
	 * 
	 * @param key
	 *            {@link String} the key to set.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * getSharedSecret.
	 * 
	 * @return the sharedSecret<br/>
	 *         is secret key for signature.
	 */
	public String getSharedSecret() {
		return sharedSecret;
	}

	/**
	 * setSharedSecret.
	 * 
	 * @param sharedSecret
	 *            {@link String} the sharedSecret to set.
	 */
	public void setSharedSecret(String sharedSecret) {
		this.sharedSecret = sharedSecret;
	}

	/**
	 * getMethod.
	 * 
	 * @return the method {@link String}<br/>
	 *         method of transaction.
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * setMethod.
	 * 
	 * @param method
	 *            {@link String}<br/>
	 *            the method to set (use the MethodEnum).
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * getBaseUrl.
	 * 
	 * @return the baseUrl {@link String}
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * setBaseUrl.
	 * 
	 * @param baseUrl
	 *            {@link String}<br/>
	 *            the baseUrl (target url) to set.
	 */
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/**
	 * getContextPath.
	 * 
	 * @return the contextPath {@link String}
	 */
	public String getContextPath() {
		return contextPath;
	}

	/**
	 * setContextPath.
	 * 
	 * @param contextPath
	 *            {@link String}<br/>
	 *            the contextPath to set.
	 */
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	/**
	 * getApiPath.
	 * 
	 * @return the apiPath {@link String}
	 */
	public String getApiPath() {
		return apiPath;
	}

	/**
	 * setApiPath<br/>
	 * is the URI.
	 * 
	 * @param apiPath
	 *            {@link String}<br/>
	 *            the apiPath to set.
	 */
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}

}
