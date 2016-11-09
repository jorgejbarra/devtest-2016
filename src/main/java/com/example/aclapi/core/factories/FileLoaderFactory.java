package com.example.aclapi.core.factories;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import com.example.aclapi.core.util.FileLoader;

public class FileLoaderFactory {

	public static FileLoader defaultFileLoader() {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource("intelliment-devtest-acl.txt");
		try {
			return new FileLoader(Paths.get(url.toURI()), RuleMapperFactory.defaultRuleMapper());
		} catch (URISyntaxException e) {
			throw new IllegalStateException("No se puede cargar el archivo de datos");
		}
	}

	public static FileLoader fileLoader(String fileName) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource(fileName);
		try {
			return new FileLoader(Paths.get(url.toURI()), RuleMapperFactory.defaultRuleMapper());
		} catch (URISyntaxException e) {
			throw new IllegalStateException("No se puede cargar el archivo de datos");
		}
	}
}
