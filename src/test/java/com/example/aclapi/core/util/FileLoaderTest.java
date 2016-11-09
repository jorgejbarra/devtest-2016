package com.example.aclapi.core.util;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.example.aclapi.core.factories.RuleLoaderFactory;

public class FileLoaderTest {

	@Test
	public void allLineOk() throws URISyntaxException {
		//given 
		RuleLoader fileLoader = RuleLoaderFactory.createFileLoader("acl-1000ok.txt");

		//when
		long count = fileLoader.load().count();

		//then
		Assert.assertTrue(count == 1000);
	}

	@Test
	public void whenLineFailContinue() throws URISyntaxException {
		//given 
		RuleLoader fileLoader = RuleLoaderFactory.createFileLoader("acl-4ok2fail.txt");

		//when
		long count = fileLoader.load().count();

		//then
		Assert.assertTrue(count == 4);
	}

}
