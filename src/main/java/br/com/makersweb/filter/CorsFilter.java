/**
 * 
 */
package br.com.makersweb.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author Anderson O. Aristides
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

	private static final String ORIGIN = "Origin";
	private Set<String> whitelist = Stream.of("http://localhost").collect(Collectors.toCollection(HashSet::new));

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		// if (request.getHeader(ORIGIN) == null ||
		// request.getHeader(ORIGIN).equals("null")) {
		// response.setHeader("Access-Control-Allow-Credentials", "true");
		// response.setHeader("Access-Control-Allow-Origin",
		// request.getHeader("Origin"));
		// response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT,
		// DELETE");
		// response.setHeader("Access-Control-Allow-Headers", "Authorization,
		// X-Requested-With, Content-Type, Accept, Origin");
		// System.out.println("ORIGIN = "+request.getHeader("Origin"));
		// System.out.println("AUTH = "+request.getHeader("Authorization"));
		// }
		// if (request.getMethod().equals("OPTIONS")) {
		// response.getWriter().print("OK");
		// response.getWriter().flush();
		// return;
		// }
		// chain.doFilter(req, res);

		String origin = request.getHeader("Origin");

		if (origin != null && whitelist.contains(origin)) {
			response.addHeader("Access-Control-Allow-Origin", origin);
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.addHeader("Access-Control-Allow-Headers", "Origin, Content-Type, Accept, Authorization");
			response.addHeader("Access-Control-Max-Age", "3600");
		}

		if (request.getMethod().equals("OPTIONS")) {
			response.getWriter().print("OK");
			response.getWriter().flush();
			return;
		}

		chain.doFilter(request, response);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
