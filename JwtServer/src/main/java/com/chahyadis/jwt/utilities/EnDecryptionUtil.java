/**
 * 
 */
package com.chahyadis.jwt.utilities;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.modelmapper.ModelMapper;

import com.chahyadis.jwt.model.JwtClaimModel;
import com.chahyadis.jwt.model.JwtHeaderModel;
import com.chahyadis.jwt.model.JwtTokenModel;
import com.nimbusds.jose.util.Base64URL;

/**
 * EnDecryptionUtil<br/>
 * for Encrypt, Encode and Decode.
 * 
 * @author Surya Chahyadi
 * @since March 25th, 2015
 * @version 1.0
 *
 */
public class EnDecryptionUtil {

	/**
	 * encodeBase64URLSafeString.
	 * 
	 * @param signature
	 *            {@link Byte}
	 * @return {@link String}
	 */
	public static String encodeBase64URLSafeString(byte[] value) {
		return Base64URL.encode(value).toString();
	}

	
	/**
	 * @param request
	 *            {@link String}<br/>
	 *            jwt token.
	 * @return {@link Map}
	 */
	public static JwtTokenModel decodeJWT(String request) {
		String jwtToken = request;
		String[] base64EncodedSegments = jwtToken.split("\\.");
		String base64EncodedHeader = base64EncodedSegments[0];
		String base64EncodedClaims = base64EncodedSegments[1];
		String signature = base64EncodedSegments[2];

		String header = base64decode(base64EncodedHeader);
		String claims = base64decode(base64EncodedClaims);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("signature", signature);
		JwtHeaderModel hm = new JwtHeaderModel();
		JwtClaimModel cm = new JwtClaimModel();
		ModelMapper mm = new ModelMapper();
		@SuppressWarnings("deprecation")
		JSONParser jp = new JSONParser();
		
		try {
			mm.map(jp.parse(header), hm);
			// setup claim
			JSONObject object = (JSONObject) jp.parse(claims);
			mm.map(object, cm);
			cm.setExp(new Date(Long.parseLong(object.get("exp").toString())*1000L));
			cm.setIat(new Date(Long.parseLong(object.get("iat").toString())*1000L));
		} catch (net.minidev.json.parser.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result.put("header", hm);
		result.put("claims", claims);

		
		return new JwtTokenModel(signature, hm, cm);
	}

	private static String base64decode(String param) {
		return StringUtils.newStringUtf8(Base64.decodeBase64(param));
	}

}
