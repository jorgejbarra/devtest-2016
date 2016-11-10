package com.example.aclapi.core.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.aclapi.core.domain.Rule;
import com.example.aclapi.core.mapper.RuleMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RuleFileLoader implements RuleLoader {
	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());
	@NonNull
	private Path			filePath;
	@NonNull
	private RuleMapper		ruleMapper;

	/* (non-Javadoc)
	 * @see com.example.aclapi.core.util.RuleLoader#load()
	 */
	@Override
	public Stream<Rule> load() {

		try {
			return Files.lines(filePath).parallel()//
					.map(ruleMapper)//
					.filter(Optional::isPresent)//
					.map(Optional::get);
		} catch (IOException e) {
			logger.error("Error en la lectura del archivo de datos", e);
			return Stream.empty();
		}
	}

}
