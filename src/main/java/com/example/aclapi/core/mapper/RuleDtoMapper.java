package com.example.aclapi.core.mapper;

import java.util.function.Function;

import com.example.aclapi.core.domain.Rule;
import com.example.aclapi.core.dto.RuleDto;

public class RuleDtoMapper implements Function<Rule, RuleDto> {

	@Override
	public RuleDto apply(Rule source) {
		RuleDto target = new RuleDto();
		target.setId(source.getId());
		target.setAction(String.valueOf(source.getAction()));
		target.setDestination(source.getDestination());
		target.setProtocol(source.getProtocol());
		target.setSource(source.getSource());
		return target;
	}

}
