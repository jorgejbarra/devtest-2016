package com.example.aclapi.core.reporitory;

import java.nio.file.Path;
import java.util.List;

import com.example.aclapi.core.domain.Rule;

public class FileAclRepository implements AclRepository {

	private final Path filePath;

	public FileAclRepository(Path filePath) {
		super();
		this.filePath = filePath;
	}

	@Override
	public List<Rule> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rule> findOneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rule> findFirstMatch(Rule filter) {
		// TODO Auto-generated method stub
		return null;
	}

}
