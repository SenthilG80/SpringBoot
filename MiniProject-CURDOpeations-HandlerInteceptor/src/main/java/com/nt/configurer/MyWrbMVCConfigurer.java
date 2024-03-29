package com.nt.configurer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.nt.Inteceptor.TimeCheckingInterceptor;

@Component
public class MyWrbMVCConfigurer implements WebMvcConfigurer {
	
	@Autowired
	private TimeCheckingInterceptor interceptor;

	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(interceptor);
	}
}
