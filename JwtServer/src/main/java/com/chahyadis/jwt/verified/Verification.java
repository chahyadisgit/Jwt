package com.chahyadis.jwt.verified;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import net.minidev.json.JSONObject;

import org.modelmapper.ModelMapper;

import com.atlassian.jwt.core.HttpRequestCanonicalizer;
import com.atlassian.jwt.exception.JwtInvalidClaimException;
import com.atlassian.jwt.httpclient.CanonicalHttpUriRequest;
import com.chahyadis.jwt.constantas.Constanta;
import com.chahyadis.jwt.interfaces.IssuerKey;
import com.chahyadis.jwt.model.JwtClaimModel;
import com.chahyadis.jwt.model.UrlContextPathModel;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jwt.JWTClaimsSet;

/**
 * Verification<br/>
 * token verification.
 * 
 * @author Surya Chahyadi
 * @since March 25th, 2015
 * @version 1.0
 */
public class Verification {

	/**
	 * signClaimValidate<br/>
	 * validate token and claim content.
	 * 
	 * @param jwt
	 *            {@link String}
	 * @param verifier
	 *            {@link JWSVerifier}
	 * @return {@link JWTClaimsSet}
	 * @throws ParseException
	 * <br/>
	 *             Parser error.
	 * @throws JOSEException
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static JWTClaimsSet signClaimValidate(String jwt,
			JWSVerifier verifier, UrlContextPathModel urlContextPathModel,
			Map<String, String[]> parameterMap, boolean isIssVal,
			IssuerKey issuerKey) throws ParseException, JOSEException,
			JwtInvalidClaimException, UnsupportedEncodingException,
			NoSuchAlgorithmException {
		JWSObject jwsObject = JWSObject.parse(jwt);

		String msg = "|Fraudulent token!";
		if (!jwsObject.verify(verifier)) {
			throw new IllegalArgumentException(Constanta.CODE_FORBIDDEN + msg);
		}

		// payload token
		JSONObject jsonPayload = jwsObject.getPayload().toJSONObject();
		// parse to JWTClaimsSet Object.
		JWTClaimsSet jcs = JWTClaimsSet.parse(jsonPayload);

		if (null == jcs.getAllClaims()) {
			throw new JwtInvalidClaimException(Constanta.CODE_UNAUTHORIZED + "|Claims no exist!");
		} else {
			// mapper to JwtClaimModel object
			ModelMapper mm = new ModelMapper();
			JwtClaimModel jcm = new JwtClaimModel();
			mm.map(jcs.getAllClaims(), jcm);

			// claim content validation
			if (null == jcm.getQsh() || null == jcm.getIat()
					|| null == jcm.getExp() || jcm.getExp().before(new Date())) {
				throw new IllegalArgumentException(Constanta.CODE_FORBIDDEN + msg);
			}

			// qsh validation
			if (!jcm.getQsh()
					.equals(qshHash(urlContextPathModel, parameterMap))) {
				throw new IllegalArgumentException(Constanta.CODE_FORBIDDEN + msg);
			}

			// iss validation
			if (isIssVal) {
				if (null == jcm.getIss()
						|| !Arrays.asList(issuerKey.appsName()).contains(jcm.getIss())) {
					throw new IllegalArgumentException(Constanta.CODE_UNAUTHORIZED + "|Illegal Client!");
				}
			}
		}

		return jcs;
	}

	private static String qshHash(UrlContextPathModel urlContextPathModel,
			Map<String, String[]> parameterMap)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		CanonicalHttpUriRequest canonical = new CanonicalHttpUriRequest(
				urlContextPathModel.getMethod(),
				urlContextPathModel.getApiPath(),
				urlContextPathModel.getContextPath(), parameterMap);

		return HttpRequestCanonicalizer.computeCanonicalRequestHash(canonical);
	}

}
