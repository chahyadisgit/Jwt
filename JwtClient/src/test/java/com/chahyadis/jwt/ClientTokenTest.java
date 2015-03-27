package com.chahyadis.jwt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.chahyadis.jwt.enumeration.MethodEnum;
import com.chahyadis.jwt.model.UrlContextPathModel;

public class ClientTokenTest extends TestCase {

	public void testCreateClientToken() {
		UrlContextPathModel urlContextPathModel = new UrlContextPathModel(180L,
				"surya project", "chahyadis", MethodEnum.POST.name(),
				"http://localhost:8080", "/jwt", "/customerServlet");
		
		Map<String, String[]> parameterMap = new HashMap<String, String[]>();
		parameterMap.put("name", new String[]{"surya"});
		parameterMap.put("gender", new String[]{"man"});
		
		ClientToken ct = new ClientToken();
		String token = "";
		try {
			token = ct.createClientToken(urlContextPathModel, parameterMap);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		System.out.println(">> token: " + token);
	}
}
