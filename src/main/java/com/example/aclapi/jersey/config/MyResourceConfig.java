package com.example.aclapi.jersey.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.example.aclapi.jersey.resources.JsonResource;

public class MyResourceConfig extends ResourceConfig {
	public MyResourceConfig() {
		super(JsonResource.class,
				// registrar Jackson ObjectMapper
				MyObjectMapperProvider.class, JacksonFeature.class);
	}
}
