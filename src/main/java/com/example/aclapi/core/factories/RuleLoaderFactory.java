package com.example.aclapi.core.factories;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import com.example.aclapi.core.util.RuleFileLoader;
import com.example.aclapi.core.util.RuleLoader;

public class RuleLoaderFactory {

	public static RuleLoader createFileLoader() {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource("intelliment-devtest-acl.txt");
		try {
			return new RuleFileLoader(Paths.get(url.toURI()), RuleMapperFactory.createRuleMapper());
		} catch (URISyntaxException e) {
			throw new IllegalStateException("No se puede cargar el archivo de datos");
		}
	}

	public static RuleLoader createFileLoader(String fileName) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(fileName);
		try {
			return new RuleFileLoader(Paths.get(url.toURI()), RuleMapperFactory.createRuleMapper());
		} catch (URISyntaxException e) {
			throw new IllegalStateException("No se puede cargar el archivo de datos");
		}
	}
}
