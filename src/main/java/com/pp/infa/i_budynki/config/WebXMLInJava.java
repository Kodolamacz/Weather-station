package com.pp.infa.i_budynki.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Blazej on 18.10.2017.
 */
public class WebXMLInJava implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(AppConfig.class);
        webContext.setServletContext(servletContext);
        webContext.refresh();
        servletContext.addListener(new ContextLoaderListener(webContext));
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",new DispatcherServlet(webContext));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }
}
