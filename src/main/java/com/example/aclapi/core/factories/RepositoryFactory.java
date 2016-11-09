package com.example.aclapi.core.factories;

import com.example.aclapi.core.reporitory.AclRepository;
import com.example.aclapi.core.reporitory.FileAclRepository;

public class RepositoryFactory {

	public static AclRepository createAclRepository() {
		return new FileAclRepository(RuleLoaderFactory.createFileLoader());
	}

}
