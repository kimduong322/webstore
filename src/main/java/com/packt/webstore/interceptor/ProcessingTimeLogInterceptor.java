package com.packt.webstore.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ProcessingTimeLogInterceptor implements HandlerInterceptor {
	private static final Logger LOGGER = Logger.getLogger(ProcessingTimeLogInterceptor.class);
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		return true; // if return false, request won't proceed to Controller or the next intercreptor
	}
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) {
		
		String queryString = request.getQueryString() == null ? "" : "?" + request.getQueryString();
		String path = request.getRequestURL() + queryString;
		
		long startTime = (Long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		LOGGER.info(String.format("%s milliseconds taken to process the request %s.",(endTime - startTime), path));
	}
	public void afterCompletion(HttpServletRequest request, // after View is rendered
			HttpServletResponse response, 
			Object handler,
			Exception exceptionIfAny) {
		// NO operation.
	}
}
