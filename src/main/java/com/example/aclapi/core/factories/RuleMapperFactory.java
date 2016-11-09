package com.example.aclapi.core.factories;

import com.example.aclapi.core.mapper.ActionMapper;
import com.example.aclapi.core.mapper.RuleMapper;

public class RuleMapperFactory {

	public static RuleMapper defaultRuleMapper() {
		return new RuleMapper(new ActionMapper());
	}
}
