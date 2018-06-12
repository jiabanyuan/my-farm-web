package com.interceptor;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域请求权限设置拦截器 
 * 
 * @author wangweihong
 * @createTime 2016年1月20日 下午1:58:10
 */
public class CorsInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(CorsInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    String origin = request.getHeader("Origin");
        if(!StringUtils.isEmpty(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept, content-type, xxxx");
            response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
       }
	    return super.preHandle(request, response, handler);
	}
}
