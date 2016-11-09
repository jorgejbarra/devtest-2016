package com.example.aclapi.core.factories;

import com.example.aclapi.core.controller.AclResourceController;
import com.example.aclapi.core.mapper.ActionMapper;
import com.example.aclapi.core.mapper.RuleDtoMapper;

public class ControllerFactory {

	public static AclResourceController createAclResourceController() {
		return new AclResourceController(RepositoryFactory.createAclRepository(), new RuleDtoMapper(), new ActionMapper());
	}

}
