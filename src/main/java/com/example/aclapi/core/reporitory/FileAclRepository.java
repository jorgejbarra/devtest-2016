package com.example.aclapi.core.reporitory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.example.aclapi.core.domain.Rule;
import com.example.aclapi.core.util.FileLoader;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FileAclRepository implements AclRepository {
	@NonNull
	private FileLoader		fileLoader;

	private Predicate<Rule>	findByIdPredicate;

	@Override
	public List<Rule> findAll() {
		return fileLoader.load().collect(Collectors.toList());
	}

	@Override
	public Optional<Rule> findOneById(int id) {
		return fileLoader.load().filter(findByIdPredicate).findFirst();
	}

	@Override
	public Optional<Rule> findFirstMatch(Predicate<Rule> predicate) {
		return fileLoader.load().filter(predicate).findFirst();
	}

}
