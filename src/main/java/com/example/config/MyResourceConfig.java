package com.example.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.example.resources.HelloWorldResource;

/**
 * {@link javax.ws.rs.core.Application} descendant.
 *
 * Used to set resource and providers classes.
 *
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
public class MyResourceConfig extends ResourceConfig {
	public MyResourceConfig() {
		super(HelloWorldResource.class);
	}
}
