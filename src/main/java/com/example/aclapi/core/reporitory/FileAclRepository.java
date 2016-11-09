package com.example.aclapi.core.reporitory;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.example.aclapi.core.domain.Rule;
import com.example.aclapi.core.util.RuleLoader;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileAclRepository implements AclRepository {
	@NonNull
	private RuleLoader fileLoader;

	@Override
	public Stream<Rule> findAll() {
		return fileLoader.load();
	}

	@Override
	public Optional<Rule> findOneById(int id) {
		return fileLoader.load().filter(r -> r.getId() == id).findFirst();
	}

	@Override
	public Optional<Rule> findFirstMatch(Predicate<Rule> predicate) {
		return fileLoader.load().filter(predicate).findFirst();
	}

}
