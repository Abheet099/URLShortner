package com.urlshortner.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Appinitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class[] config = {URLappconfig.class};
		
		return config;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		
		String mapping[] = {"/"};
		
		return mapping;
	}

}
