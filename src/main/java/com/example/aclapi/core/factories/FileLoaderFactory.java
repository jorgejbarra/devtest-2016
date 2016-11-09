package com.example.aclapi.core.factories;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import com.example.aclapi.core.util.FileLoader;

public class FileLoaderFactory {

	public static FileLoader defaultFileLoader() {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource("acl-1000ok.txt");
		try {
			return FileLoader.builder().filePath(Paths.get(url.toURI())).ruleMapper(RuleMapperFactory.defaultRuleMapper()).build();
		} catch (URISyntaxException e) {
			throw new IllegalStateException("No se puede cargar el archivo de datos");
		}
	}
}
