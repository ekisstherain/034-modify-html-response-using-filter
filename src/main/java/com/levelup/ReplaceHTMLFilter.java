package com.levelup;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ReplaceHTMLFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		HtmlResponseWrapper capturingResponseWrapper = new HtmlResponseWrapper(
				(HttpServletResponse) response);

		filterChain.doFilter(request, capturingResponseWrapper);

		if (response.getContentType() != null
				&& response.getContentType().contains("text/html")) {

			String content = capturingResponseWrapper.getCaptureAsString();

			// replace stuff here
			String replacedContent = content.replaceAll("<h2[^>]*>(.*?)</h2>",
					"<h3>$1 - HTML replaced</h3>");

			System.out.println(replacedContent);

			response.getWriter().write(replacedContent);

		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
