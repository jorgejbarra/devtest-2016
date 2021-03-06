package com.example.aclapi.jersey;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

import com.example.aclapi.jersey.config.MyResourceConfig;

public class App {

	private static final URI BASE_URI = URI.create("http://localhost:8080/intelliment/");

	public static void main(String[] args) {
		try {
			System.out.println("\"devtest 2016\" Jersey Example App");

			final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, new MyResourceConfig(), false);
			Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
				@Override
				public void run() {
					server.shutdownNow();
				}
			}));
			server.start();
			Thread.currentThread().join();
		} catch (IOException | InterruptedException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}
