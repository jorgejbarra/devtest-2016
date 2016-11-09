package com.example.aclapi.core;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileLoader {

	public void load(String[] args) throws URISyntaxException {

		List<String> list = new ArrayList<>();
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		URL url = classloader.getResource("intelliment-devtest-acl.txt");

		try (Stream<String> stream = Files.lines(Paths.get(url.toURI()))) {

			//1. filter line 3
			//2. convert all content to upper case
			//3. convert it into a List
			//list = 
			stream//
					.forEach(s -> consume(s));
			//.filter(line -> !line.startsWith("line3"))//
			//.map(String::toUpperCase).collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);

	}

}
