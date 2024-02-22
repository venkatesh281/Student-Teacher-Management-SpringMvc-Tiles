package com.studentManagement.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ManagementApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[] {
	            BeanConfig.class
	        };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class aClass[] = {BeanConfig.class }; 
        return aClass;
		
	}

	@Override
	protected String[] getServletMappings() {
		 String arr[] = { "/" }; 
	        return arr; 
	
	}
	
	
	
	

}
