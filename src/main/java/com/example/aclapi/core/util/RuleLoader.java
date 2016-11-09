package com.example.aclapi.core.util;

import java.util.stream.Stream;

import com.example.aclapi.core.domain.Rule;

public interface RuleLoader {

	Stream<Rule> load();

}