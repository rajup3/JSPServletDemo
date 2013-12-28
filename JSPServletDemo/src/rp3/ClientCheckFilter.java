package rp3;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ClientCheckFilter implements Filter{

	@Override
	public void init(FilterConfig fc) throws ServletException {
		System.out.println(" ClientCheckFilter.init() ... ");		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println(" ClientCheckFilter.doFilter() ... ");
		 String ipAddress = request.getRemoteAddr();

	     // Log the IP address and current timestamp.
	     System.out.println("IP "+ ipAddress + ", Time "+ new Date().toString());
	     
	     filterChain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println(" ClientCheckFilter.destroy() ... ");
	}
}
