/**
 * 
 */
package com.chahyadis.jwt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import com.atlassian.jwt.SigningAlgorithm;
import com.atlassian.jwt.core.JwtUtil;
import com.atlassian.jwt.core.TimeUtil;
import com.atlassian.jwt.core.writer.JsonSmartJwtJsonBuilder;
import com.atlassian.jwt.core.writer.JwtClaimsBuilder;
import com.atlassian.jwt.core.writer.NimbusJwtWriterFactory;
import com.atlassian.jwt.httpclient.CanonicalHttpUriRequest;
import com.atlassian.jwt.writer.JwtJsonBuilder;
import com.atlassian.jwt.writer.JwtWriterFactory;
import com.chahyadis.jwt.constant.ConstantaVariable;
import com.chahyadis.jwt.model.UrlContextPathModel;

/**
 * ClientToken<br/>
 * Client Authentication Token.
 * 
 * @author Surya Chahyadi
 * @since March 24th, 2015
 * @version 1.0
 */
public class ClientToken {

	/**
	 * createClientToken<br/>
	 * generate token.
	 * 
	 * @param urlContextPathModel
	 *            {@link UrlContextPathModel}
	 * @param parameterMap
	 *            {@link Map}<br/>
	 *            parameter (from query string).
	 * @return {@link String}<br/>
	 *         url with token.
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public String createClientToken(UrlContextPathModel urlContextPathModel,
			Map<String, String[]> parameterMap)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		long issuedAt = TimeUtil.currentTimeSeconds();
		long expiresAt = issuedAt + urlContextPathModel.getExpiresAt();
		String key = urlContextPathModel.getKey();
		String sharedSecret = JwtUtil
				.computeSha256Hash((null == urlContextPathModel
						.getSharedSecret() ? ConstantaVariable.DEFAULT_SHARED_KEY
						: urlContextPathModel.getSharedSecret()));
		System.out.println(sharedSecret);

		String method = urlContextPathModel.getMethod();
		String contextPath = urlContextPathModel.getContextPath();
		String baseUrl = urlContextPathModel.getBaseUrl() + contextPath;
		String apiPath = urlContextPathModel.getApiPath();

		// create claim
		JwtJsonBuilder jwtBuilder = new JsonSmartJwtJsonBuilder()
				.issuedAt(issuedAt).expirationTime(expiresAt).issuer(key);

		CanonicalHttpUriRequest canonical = new CanonicalHttpUriRequest(method,
				apiPath, contextPath, parameterMap);
		JwtClaimsBuilder.appendHttpRequestClaims(jwtBuilder, canonical);

		// claim content
		String jwtbuilt = jwtBuilder.build();

		// create jwt token
		JwtWriterFactory jwtWriterFactory = new NimbusJwtWriterFactory();
		String jwtToken = jwtWriterFactory.macSigningWriter(
				SigningAlgorithm.HS256, sharedSecret).jsonToJwt(jwtbuilt);

		return baseUrl + apiPath + "?jwt=" + jwtToken;
	}

}
