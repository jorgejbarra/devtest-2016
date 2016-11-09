package com.example.aclapi.core.reporitory;

import java.util.List;

import com.example.aclapi.core.domain.Rule;

public interface AclRepository {

	List<Rule> findAll();

	List<Rule> findOneById(int id);

	List<Rule> findFirstMatch(Rule filter);

}
