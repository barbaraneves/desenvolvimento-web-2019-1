package index;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class Filtro implements Filter {

	public Filtro() {
		
	}
	
	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession sessao = httpRequest.getSession();
		
		if (sessao.getAttribute("usuario-logado") != null ||
				httpRequest.getRequestURI().endsWith("login") ||
				httpRequest.getRequestURI().endsWith("efetuar-login") ||
				httpRequest.getRequestURI().contains("Atividade05")) {
				
			chain.doFilter(request, response);
			
			return;
		} 
		
		httpResponse.sendRedirect("login");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
}
