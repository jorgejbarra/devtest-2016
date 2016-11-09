package com.example.aclapi.core.util;

import com.example.aclapi.core.dto.RuleFilterParam;

public class RuleFilterParamValidator {

	public boolean isEmpty(RuleFilterParam filter) {

		return filter.getId() == null && filter.getSource() == null && filter.getDestination() == null && filter.getProtocol() == null && filter.getAction() == null;
	}

}
