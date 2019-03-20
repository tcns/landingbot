package ru.cedra.landingbot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import ru.cedra.landingbot.LandingbotApp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {
//    @Autowired
//    ApplicationContext applicationContext;
////    @Override
////    public void addResourceHandlers(ResourceHandlerRegistry registry) {
////        registry.addResourceHandler("/sites/**")
////            .addResourceLocations("file:" + LandingbotApp.IMAGE_DIR);
////        super.addResourceHandlers(registry);
////    }
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/sites").setViewName(LandingbotApp.IMAGE_DIR);
//        //registry.addViewController("/docs/").setViewName("forward:/docs/index.html");
//        super.addViewControllers(registry);
//    }
//    @Bean
//    public SimpleUrlHandlerMapping sampleServletMapping() {
//        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
//        mapping.setOrder(0);
//
//        Map<String, Object> urlMap = new HashMap<>();
//        urlMap.put("/sites/**", resourceHttpRequestHandler());
//        mapping.setUrlMap(urlMap);
//
//
//
//        return mapping;
//    }
//
//    @Bean
//    public ResourceHttpRequestHandler resourceHttpRequestHandler() {
//        ResourceHttpRequestHandler httpRequestHandler = new ResourceHttpRequestHandler();
//        httpRequestHandler.setLocations(Arrays.asList(applicationContext.getResource(LandingbotApp.IMAGE_DIR)));
//        httpRequestHandler.setSupportedMethods("GET", "POST");
//        return httpRequestHandler;
//    }
}
