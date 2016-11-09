package com.example.aclapi.core.reporitory;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.example.aclapi.core.domain.Rule;

public interface AclRepository {

	Stream<Rule> findAll();

	Optional<Rule> findOneById(int id);

	Optional<Rule> findFirstMatch(Predicate<Rule> pewdicate);

}
