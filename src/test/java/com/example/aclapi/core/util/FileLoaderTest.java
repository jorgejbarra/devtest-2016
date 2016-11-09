package com.example.aclapi.core.util;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;

import com.example.aclapi.core.factories.FileLoaderFactory;
import com.example.aclapi.core.factories.RuleMapperFactory;

public class FileLoaderTest {

	@Test
	public void allLineOk() throws URISyntaxException {
		//given 
		FileLoader fileLoader = FileLoaderFactory.defaultFileLoader();

		//when
		long count = fileLoader.load().count();

		//then
		Assert.assertTrue(count == 1000);
	}

	@Test
	public void whenLineFailContinue() throws URISyntaxException {
		//given 
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource("acl-4ok2fail.txt");
		FileLoader fileLoader = FileLoader.builder().filePath(Paths.get(url.toURI())).ruleMapper(RuleMapperFactory.defaultRuleMapper()).build();

		//when
		long count = fileLoader.load().count();

		//then
		Assert.assertTrue(count == 4);
	}

}
