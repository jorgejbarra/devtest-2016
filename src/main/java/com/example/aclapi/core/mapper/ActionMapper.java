package com.example.aclapi.core.mapper;

import com.example.aclapi.core.domain.Action;

public class ActionMapper {

	public Action toAction(String string) {
		return Action.valueOf(string.toUpperCase());
	}

}
