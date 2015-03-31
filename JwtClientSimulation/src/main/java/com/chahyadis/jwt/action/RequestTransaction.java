/**
 * 
 */
package com.chahyadis.jwt.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.chahyadis.jwt.ClientToken;
import com.chahyadis.jwt.constantas.Constanta;
import com.chahyadis.jwt.enumeration.MethodEnum;
import com.chahyadis.jwt.model.UrlContextPathModel;

/**
 * RequestTransaction.
 * 
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public class RequestTransaction extends IssuerKeySetup {

	public void action() {
		// setup parameter for token
		Map<String, String[]> parameterMap = new HashMap<String, String[]>();
		parameterMap.put("name", new String[] { "chahyadis" });

		// setup parameter for target
		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
			for (String val : entry.getValue()) {
				urlParameters.add(new BasicNameValuePair(entry.getKey(), val));	
			}
		}
		
		try {
			HttpClient client = new DefaultHttpClient();
			String token = requestToken(Constanta.BASE_URL,
					Constanta.CONTEXT_PATH, "/ServerValidateJwtServlet",
					MethodEnum.POST.name(), parameterMap);
			System.out.println(">> token: " + token);
			HttpPost post = new HttpPost(token);
			post.setHeader("User-Agent", Constanta.USER_AGENT);
			post.setEntity(new UrlEncodedFormEntity(urlParameters));
			HttpResponse response = client.execute(post);

			System.out.println("\nSending 'POST' request to URL : "
					+ Constanta.BASE_URL);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : "
					+ response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}

			System.out.println(result.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String requestToken(String baseUrl, String contextPath,
			String apiPath, String method, Map<String, String[]> parameterMap) {
		UrlContextPathModel urlContextPathModel = new UrlContextPathModel();
		urlContextPathModel.setBaseUrl(baseUrl);
		urlContextPathModel.setContextPath(contextPath);
		urlContextPathModel.setApiPath(apiPath);
		urlContextPathModel.setMethod(method);
		urlContextPathModel.setKey(this.appName());
		urlContextPathModel.setExpiresAt(180L);

		ClientToken ct = new ClientToken();
		String token = null;
		try {
			token = ct.createClientToken(urlContextPathModel, parameterMap);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return token;
	}
}
