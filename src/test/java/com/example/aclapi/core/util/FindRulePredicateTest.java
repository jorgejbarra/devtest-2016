package com.example.aclapi.core.util;

import org.junit.Assert;
import org.junit.Test;

import com.example.aclapi.core.domain.Action;
import com.example.aclapi.core.domain.Rule;

public class FindRulePredicateTest {

	@Test
	public void findById() {
		FindRulePredicate predicate = FindRulePredicate.builder().id(1).build();
		Rule positiveRule = Rule.builder().id(1).build();
		Rule negativeRule = Rule.builder().id(20).build();

		Assert.assertTrue(predicate.test(positiveRule));
		Assert.assertFalse(predicate.test(negativeRule));

	}

	@Test
	public void findByAction() {
		FindRulePredicate predicate = FindRulePredicate.builder().action(Action.DENY).build();
		Rule positiveRule = Rule.builder().action(Action.DENY).build();
		Rule negativeRule = Rule.builder().action(Action.ALLOW).build();

		Assert.assertTrue(predicate.test(positiveRule));
		Assert.assertFalse(predicate.test(negativeRule));

	}

	@Test
	public void findByActionAndId() {
		FindRulePredicate predicate = FindRulePredicate.builder().id(1).action(Action.DENY).build();
		Rule positiveRule = Rule.builder().id(1).action(Action.DENY).build();
		Rule negativeRule = Rule.builder().id(1).action(Action.ALLOW).build();

		Assert.assertFalse(predicate.test(negativeRule));
		Assert.assertTrue(predicate.test(positiveRule));

	}
}
