/**
 * 
 */
package com.chahyadis.jwt.model;

import com.chahyadis.jwt.constantas.Constanta;

/**
 * JsonOutModel.
 * 
 * @author Surya Chahyadi
 * @since March 26th, 2015
 * @version 1.0
 */
public class JsonOutModel {
	private int code;
	private String message;
	private int errCode;

	public JsonOutModel() {
	}

	/**
	 * JsonOutModel.
	 * 
	 * @param code
	 *            {@link Integer}<br/>
	 *            Kode Transaksi(0:success, 1:failed)<br/>
	 *            referensi lihat {@link Constanta}.
	 * @param message
	 *            {@link String}<br/>
	 *            result transaksi.
	 * @param errCode
	 *            {@link Integer}<br/>
	 *            error kode transaksi.
	 */
	public JsonOutModel(int code, String message, int errCode) {
		super();
		this.code = code;
		this.message = message;
		this.errCode = errCode;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the errCode
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode
	 *            the errCode to set
	 */
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

}
