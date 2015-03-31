/**
 * 
 */
package com.chahyadis.jwt.verified;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.atlassian.jwt.exception.JwtInvalidClaimException;
import com.chahyadis.jwt.constant.ConstantaVariable;
import com.chahyadis.jwt.interfaces.IssuerKey;
import com.chahyadis.jwt.model.UrlContextPathModel;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

/**
 * ParameterSetupVerification<br/>
 * Setup parameter for token verification.
 * 
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public class ParameterSetupVerification {

	/**
	 * @param request
	 *            {@link HttpServletRequest}
	 * @param sharedSecret
	 *            {@link String}<br/>
	 *            kata sandi yang akan digunakan sebagai parameter kunci
	 *            signature.
	 * @param isIssVal
	 *            {@link Boolean}<br/>
	 *            status key/identitas project, apakah perlu divalidasi ?.
	 * @param issuerKey
	 * <br/>
	 *            key/identitas project.
	 * @return {@link JWTClaimsSet}
	 * @throws JwtInvalidClaimException
	 * <br/>
	 *             error untuk nilai Klaim yang tidak sesuai.
	 * @throws NoSuchAlgorithmException
	 * <br/>
	 *             error algoritma yang tidak sesuai.
	 * @throws IllegalArgumentException
	 * <br/>
	 *             error karena ketidak sesuaian argumen yang dikirimkan oleh
	 *             client.
	 * @throws ParseException
	 * @throws JOSEException
	 * @throws IOException
	 */
	public JWTClaimsSet validateToken(HttpServletRequest request,
			String sharedSecret, boolean isIssVal, IssuerKey issuerKey)
			throws JwtInvalidClaimException, NoSuchAlgorithmException,
			IllegalArgumentException, ParseException, JOSEException,
			IOException {

		JWTClaimsSet jwtClaimsSet = null;
		String jwt = request.getParameter("jwt");

		// token format validation
		if (jwt.split("\\.").length == 3) {
			// setup urlContextpath;
			UrlContextPathModel urlContextPathModel = new UrlContextPathModel();
			urlContextPathModel.setMethod(request.getMethod());
			urlContextPathModel.setContextPath(request.getContextPath());
			urlContextPathModel.setApiPath(request.getServletPath());

			// token detail verification
			jwtClaimsSet = Verification
					.signClaimValidate(
							jwt,
							new SignatureVerification(
									null == sharedSecret ? ConstantaVariable.DEFAULT_SHARED_KEY
											: sharedSecret),
							urlContextPathModel, parameterSetup(request),
							isIssVal, issuerKey);

		}

		return jwtClaimsSet;

	}

	/**
	 * parameterSetup<br/>
	 * setup parameter from client.
	 * 
	 * @param request
	 *            {@link HttpServletRequest}
	 * @return {@link Map}
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, String[]> parameterSetup(HttpServletRequest request) {
		Map<String, String[]> parameterMap = new HashMap<String, String[]>();
		Enumeration enumeration = request.getParameterNames();
		String parameterName;
		while (enumeration.hasMoreElements()) {
			parameterName = (String) enumeration.nextElement();
			if (!parameterName.equalsIgnoreCase("jwt")) {
				parameterMap.put(parameterName,
						request.getParameterValues(parameterName));
			}
		}

		return parameterMap;
	}

}
