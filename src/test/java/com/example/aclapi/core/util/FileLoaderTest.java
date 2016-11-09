package com.example.aclapi.core.util;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import com.example.aclapi.core.factories.FileLoaderFactory;

public class FileLoaderTest {

	@Test
	public void allLineOk() throws URISyntaxException {
		//given 
		FileLoader fileLoader = FileLoaderFactory.fileLoader("acl-1000ok.txt");

		//when
		long count = fileLoader.load().count();

		//then
		Assert.assertTrue(count == 1000);
	}

	@Test
	public void whenLineFailContinue() throws URISyntaxException {
		//given 
		FileLoader fileLoader = FileLoaderFactory.fileLoader("acl-4ok2fail.txt");

		//when
		long count = fileLoader.load().count();

		//then
		Assert.assertTrue(count == 4);
	}

}
