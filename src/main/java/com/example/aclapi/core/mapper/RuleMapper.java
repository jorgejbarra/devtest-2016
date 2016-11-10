package com.example.aclapi.core.mapper;

import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.aclapi.core.domain.Rule;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RuleMapper implements Function<String, Optional<Rule>> {
	private static final int	ID_GROUP			= 1;
	private static final int	SOURCE_GROUP		= 2;
	private static final int	DESTINATION_GROUP	= 3;
	private static final int	PROTOCOL_GROUP		= 4;
	private static final int	ACTION_GROUP		= 5;
	private static final int	NUMBER_OF_GROUP		= 5;

	private final Logger		logger				= LoggerFactory.getLogger(this.getClass());
	private final Pattern		p					= Pattern.compile("(\\d+) FROM ([\\w+\\.\\/]+) TO ([\\w+\\.\\/]+) WITH ([\\w\\/\\,]+) => (\\w+)", Pattern.CASE_INSENSITIVE);

	@NonNull
	private final ActionMapper	actionMapper;

	@Override
	public Optional<Rule> apply(String line) {
		Matcher m = p.matcher(line);

		Rule result = null;
		if (m.matches() && m.groupCount() == NUMBER_OF_GROUP) {
			result = Rule.builder()//
					.id(Integer.parseInt(m.group(ID_GROUP)))//
					.source(m.group(SOURCE_GROUP))//
					.destination(m.group(DESTINATION_GROUP))//
					.protocol(m.group(PROTOCOL_GROUP))//
					.action(actionMapper.toAction(m.group(ACTION_GROUP)))//
					.build();

		} else {
			logger.error("Linea con formato incorrecto: " + line);
		}
		return Optional.ofNullable(result);
	}

}
