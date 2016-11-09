package com.example.aclapi.core.reporitory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.example.aclapi.core.domain.Rule;

public interface AclRepository {

	List<Rule> findAll();

	Optional<Rule> findOneById(int id);

	Optional<Rule> findFirstMatch(Predicate<Rule> pewdicate);

}
