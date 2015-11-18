package xinguan.zhang.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * �������ͨ�õĹ���������
 * 
 * @author seawind
 */
public class EncodingFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// ���post
		request.setCharacterEncoding("utf-8");
		// ���get
		EncodingRequest encodingRequest = new EncodingRequest(
				(HttpServletRequest) request);
		// �����Ӧ
		response.setContentType("text/html;charset=utf-8");

		chain.doFilter(encodingRequest, response);

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}

class EncodingRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	private boolean hasEncode = false;

	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}

	@Override
	public String getParameter(String name) {
		// ͨ��getParameterMap�������
		String[] values = getParameterValues(name);
		if (values == null) {
			return null;
		}
		return values[0];
	}

	@Override
	public String[] getParameterValues(String name) {
		// ͨ��getParameterMap�������
		Map<String, String[]> parameterMap = getParameterMap();
		String[] values = parameterMap.get(name);
		return values;
	}

	@Override
	public Map getParameterMap() {
		Map<String, String[]> parameterMap = request.getParameterMap();
		String method = request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			return parameterMap;
		}

		// get�ύ��ʽ �ֶ�ת�� , �����ת��ֻ����һ�� ����ͨ�� hasEncode �������ͱ�������
		if (!hasEncode) {
			Set<String> keys = parameterMap.keySet();
			for (String key : keys) {
				String[] values = parameterMap.get(key);
				if (values == null) {
					continue;
				}
				for (int i = 0; i < values.length; i++) {
					String value = values[i];
					// ���get
					try {
						value = new String(value.getBytes("ISO-8859-1"),
								"utf-8");
						// values��һ����ַ
						values[i] = value;
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				// һ��ת����ɺ�����ת��״̬Ϊtrue
				hasEncode = true;
			}
		}
		return parameterMap;
	}
}
