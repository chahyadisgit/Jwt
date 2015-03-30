package com.chahyadis.jwt.verified;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Set;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.StringUtils;

import com.atlassian.jwt.core.JwtUtil;
import com.chahyadis.jwt.utilities.EnDecryptionUtil;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeaderFilter;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.ReadOnlyJWSHeader;
import com.nimbusds.jose.util.Base64URL;

/**
 * SignatureVerification implements {@link JWSVerifier}<br/>
 * Signature verification.
 * 
 * @author Surya Chahyadi
 * @since March 24th, 2015
 * @version 1.0
 */
public class SignatureVerification implements JWSVerifier {

	private String sharedSecret;

	public SignatureVerification(String sharedSecret) {
		try {
			this.sharedSecret = JwtUtil.computeSha256Hash(sharedSecret);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nimbusds.jose.JWSAlgorithmProvider#supportedAlgorithms()
	 */
	public Set<JWSAlgorithm> supportedAlgorithms() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.nimbusds.jose.JWSVerifier#getJWSHeaderFilter()
	 */
	public JWSHeaderFilter getJWSHeaderFilter() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.nimbusds.jose.JWSVerifier#verify(com.nimbusds.jose.ReadOnlyJWSHeader,
	 * byte[], com.nimbusds.jose.util.Base64URL)
	 */
	public boolean verify(ReadOnlyJWSHeader header, byte[] signingInput,
			Base64URL signature) throws JOSEException {

		String[] token = StringUtils.newStringUtf8(signingInput).split("\\.");

		// signingInput format validation
		if (token.length != 2) {
			return false;
		}

		try {
			// create signature
			String newSignature = signHmac256(
					StringUtils.newStringUtf8(signingInput), null);

			// validate signature
			if (newSignature.equals(signature.toString())) {
				return true;
			}
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * signHmac256<br/>
	 * HASH256.
	 * 
	 * @param signingInput
	 *            {@link String}<br/>
	 *            header concate with claim.
	 * @param encType
	 *            {@link String} encryption model.
	 * @return {@link String} signature.
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	private String signHmac256(String signingInput, String encType)
			throws NoSuchAlgorithmException, InvalidKeyException {
		String typeEnc = (null != encType ? encType : "HmacSHA256");
		SecretKey key = new SecretKeySpec(sharedSecret.getBytes(), typeEnc);
		Mac mac = Mac.getInstance(typeEnc);
		mac.init(key);

		return EnDecryptionUtil.encodeBase64URLSafeString(mac.doFinal(signingInput.getBytes()));
	}
}
