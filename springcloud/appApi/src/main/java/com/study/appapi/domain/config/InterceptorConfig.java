package com.study.appapi.domain.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Classname: HotelController
 * 描述:
 * @Author: Kt.w
 * @Date: 2019/6/14
 * @Version 1.0
 * @Since 1.0
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {



	@Autowired
	private LoginAuthenticationInterceptor loginAuthenticationInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {


		// 只能在登录的情况下操作
		registry.addInterceptor(loginAuthenticationInterceptor).addPathPatterns("/login/**");

	}


}