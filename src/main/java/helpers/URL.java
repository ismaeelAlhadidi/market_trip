package helpers;

import javax.servlet.http.HttpServletRequest;

public class URL {
	public static String getBaseUrl(HttpServletRequest request) {
		String scheme = request.getScheme() + "://";
		String serverName = request.getServerName();
		String serverPort = (request.getServerPort() == 80) ? "" : ":" + request.getServerPort();
		String contextPath = request.getContextPath();
		return scheme + serverName + serverPort + contextPath;
	}
	public static String fixTheSearchQuery(String _s) {
		char[] s = _s.toCharArray();
		for(int i = 0; i < s.length; ++i) {
			if(s[i] == '_') {
				s[i] = '&';
			} else if(s[i] == 'x') {
				s[i] = ' ';
			}
		}
		return new String(s);
	}
}
