package com.example.aclapi.core.factories;

import com.example.aclapi.core.reporitory.AclRepository;
import com.example.aclapi.core.reporitory.FileAclRepository;

public class AclRepositoryFactory {

	public AclRepository create() {
		return new FileAclRepository(RuleLoaderFactory.defaultFileLoader());
	}

}
