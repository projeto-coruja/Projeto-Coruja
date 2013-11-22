package webview.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class ParamsWrapper {

	private final static String CHARSET_IN = "ISO8859_1";
	private final static String CHARSET_OUT = "UTF-8";
	
	private HttpServletRequest delegateRequest;
	
	public ParamsWrapper(HttpServletRequest req) {
		delegateRequest = req;
	}
	
	public String getParameter(String param) {
		String value = delegateRequest.getParameter(param);
		try {
			return new String(value.getBytes(CHARSET_IN), CHARSET_OUT);
		} catch (UnsupportedEncodingException e) {
			return value;
		}
	}
	
}
