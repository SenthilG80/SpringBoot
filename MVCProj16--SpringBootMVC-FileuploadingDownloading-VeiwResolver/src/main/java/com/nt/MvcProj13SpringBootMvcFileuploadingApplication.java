package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@SpringBootApplication
public class MvcProj13SpringBootMvcFileuploadingApplication {
	/*
	 * @Bean public InternalResourceViewResolver createViewResolver() {
	 * InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	 * resolver.setPrefix("/WEB-INF/pages/"); resolver.setSuffix(".jsp"); return
	 * resolver; }
	 */
	/*
	 * @Bean public UrlBasedViewResolver create1Resolver() { UrlBasedViewResolver
	 * resolver=new UrlBasedViewResolver(); resolver.setPrefix("/WEB-INF/pages/");
	 * resolver.setSuffix(".jsp"); resolver.setViewClass(JstlView.class); // for non
	 * jstl in build gradle we need to use below
	 * //resolver.setViewClass(InternalResourceView.class); return resolver; }
	 */

	
	 @Bean 
	 public ResourceBundleViewResolver createRBVResolver() {
	  ResourceBundleViewResolver resolver=new ResourceBundleViewResolver(); 
	  return resolver; 
	  }
	 
	@Bean(name = "multipartResolver")
	public StandardServletMultipartResolver createResolver() {
		StandardServletMultipartResolver resolver = new StandardServletMultipartResolver();
		return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(MvcProj13SpringBootMvcFileuploadingApplication.class, args);
	}

}
