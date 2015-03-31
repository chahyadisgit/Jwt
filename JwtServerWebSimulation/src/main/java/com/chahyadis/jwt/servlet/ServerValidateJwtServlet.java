package com.chahyadis.jwt.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.minidev.json.JSONObject;

import com.atlassian.jwt.exception.JwtInvalidClaimException;
import com.chahyadis.jwt.action.IssuerKeySetup;
import com.chahyadis.jwt.constant.ConstantaVariable;
import com.chahyadis.jwt.constantas.Constanta;
import com.chahyadis.jwt.model.JsonOutModel;
import com.chahyadis.jwt.model.JwtClaimModel;
import com.chahyadis.jwt.model.JwtHeaderModel;
import com.chahyadis.jwt.model.JwtTokenModel;
import com.chahyadis.jwt.utilities.EnDecryptionUtil;
import com.chahyadis.jwt.verified.ParameterSetupVerification;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

/**
 * Servlet implementation class ServerValidateJwtServlet.
 * 
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public class ServerValidateJwtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServerValidateJwtServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		JsonOutModel jom = new JsonOutModel();
		jom.setCode(Constanta.SUCCESS_STATUS);
		jom.setErrCode(Constanta.CODE_SUCCESS);
		jom.setMessage("Hei...hei... ini untuk coba coba aja ya...!");

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", jom);
		response.getWriter().write(jsonObject.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		JsonOutModel jom = new JsonOutModel();

		String message = null;
		ParameterSetupVerification psv = new ParameterSetupVerification();
		try {
			// get parameter names
			Enumeration enumeration = request.getParameterNames();
			String parameterName;
			while (enumeration.hasMoreElements()) {
				parameterName = (String) enumeration.nextElement();
				System.out.println(">>> parameter: " + parameterName);
			}

			// token info
			JwtTokenModel tokenModel = EnDecryptionUtil.decodeJWT(request
					.getParameter("jwt"));
			JwtHeaderModel jhm = tokenModel.getJwtHeaderModel();
			System.out.println(jhm.toString());

			JwtClaimModel jcm = tokenModel.getJwtClaimModel();
			System.out.println(jcm.toString());
			System.out.println(">> signature: " + tokenModel.getSignature());

			JWTClaimsSet jcs = psv.validateToken(request,
					ConstantaVariable.DEFAULT_SHARED_KEY, true,
					new IssuerKeySetup());

			jom.setCode(Constanta.SUCCESS_STATUS);
			jom.setMessage("token valid!");
			jom.setErrCode(Constanta.CODE_SUCCESS);
		} catch (JwtInvalidClaimException e) {
			message = "400|JwtInvalidClaimException: " + e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			message = "400|NoSuchAlgorithmException: " + e.getMessage();
		} catch (ParseException e) {
			message = "400|ParseException: " + e.getMessage();
		} catch (JOSEException e) {
			message = "400|JOSEException: " + e.getMessage();
		} catch (IllegalArgumentException e) {
			message = e.getMessage();
		}

		if (null != message) {
			System.out.println(">> message: " + message);
			String[] msg = message.split("\\|");
			jom.setMessage(msg[1]);
			jom.setCode(Constanta.FAILED_STATUS);
			jom.setErrCode(Integer.valueOf(msg[0]));
		}

		JSONObject jsonObject = new JSONObject();
		if (null != jom.getMessage()) {
			jsonObject.put("Result: ", jom);
		}

		response.getWriter().write(jsonObject.toJSONString());
	}

}
