package com.example.aclapi.core.factories;

import com.example.aclapi.core.mapper.ActionMapper;
import com.example.aclapi.core.mapper.RuleMapper;

public class RuleMapperFactory {

	public static RuleMapper createRuleMapper() {
		return new RuleMapper(new ActionMapper());
	}
}
