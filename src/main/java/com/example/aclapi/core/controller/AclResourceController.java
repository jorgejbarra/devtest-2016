package com.example.aclapi.core.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.aclapi.core.dto.RuleDto;
import com.example.aclapi.core.dto.RuleFilterParam;
import com.example.aclapi.core.mapper.ActionMapper;
import com.example.aclapi.core.mapper.RuleDtoMapper;
import com.example.aclapi.core.reporitory.AclRepository;
import com.example.aclapi.core.util.FindRulePredicate;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AclResourceController {
	@NonNull
	private AclRepository	repository;
	@NonNull
	private RuleDtoMapper	ruleDtoMapper;
	@NonNull
	private ActionMapper	actionMapper;

	public List<RuleDto> findAll() {
		return repository.findAll().map(ruleDtoMapper).collect(Collectors.toList());
	}

	public Optional<RuleDto> findOneById(int id) {
		return repository.findOneById(id).map(ruleDtoMapper);
	}

	public Optional<RuleDto> findFirstMatch(RuleFilterParam ruleFilterParam) {

		FindRulePredicate predicate = FindRulePredicate.builder().id(ruleFilterParam.getId())//
				.action(actionMapper.toAction(ruleFilterParam.getAction()))//
				.destination(ruleFilterParam.getDestination())//
				.source(ruleFilterParam.getSource())//
				.protocol(ruleFilterParam.getProtocol())//
				.build();

		return repository.findFirstMatch(predicate).map(ruleDtoMapper);
	}

}
