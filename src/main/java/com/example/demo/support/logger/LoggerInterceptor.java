package com.example.demo.support.logger;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		if (log.isDebugEnabled()) {
		}
		log.info(
				"======================================          START         ======================================");
		log.info(System.currentTimeMillis() + " Request URI \t:  " + request.getRequestURI());
    	System.out.println("method:" + request.getMethod());
    	System.out.println("header:" + request.getHeader("tokens"));   
    	System.out.println("uri:" + request.getRequestURI()); 
    	
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("endTime", System.currentTimeMillis());
		if (log.isDebugEnabled()) {
		}
		log.info("======================================           END          ======================================\n");
		log.info(System.currentTimeMillis() + " Request URI \t:  " + request.getRequestURI());
	
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		Long startTime = (Long) request.getAttribute("startTime");
		Long endTime = (Long) request.getAttribute("endTime");
		if(endTime == null) {
			log.info("Time Spent in Handler in ms : " + (endTime - startTime));
		}

	}

}