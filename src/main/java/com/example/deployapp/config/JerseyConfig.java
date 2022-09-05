package com.example.deployapp.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("api")
public class JerseyConfig extends ResourceConfig {
	
	@PostConstruct
    private void init() {
    	packages(true, "com.example.deployapp.rest");
        //registerClasses(ApiClass.class);
    }

}
