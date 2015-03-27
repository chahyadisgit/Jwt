/**
 * 
 */
package com.chahyadis.jwt.verified;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
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
	public JWTClaimsSet validateToken(HttpServletRequest request,
			Map<String, String[]> parameterMap, String sharedSecret,
			boolean isIssVal, IssuerKey issuerKey)
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
							urlContextPathModel, parameterMap, isIssVal,
							issuerKey);

		}

		return jwtClaimsSet;

	}

}
