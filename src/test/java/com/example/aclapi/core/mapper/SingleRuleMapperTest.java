package com.example.aclapi.core.mapper;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import com.example.aclapi.core.domain.Action;
import com.example.aclapi.core.domain.SingleRule;

public class SingleRuleMapperTest {

	@Test
	public void rightLineProduceRigthRule() {
		//given
		String line = "1 from 43.0.0.0/8 to any with udp/53839,49944,58129,21778 => deny";
		SingleRuleMapper singleRuleMapper = new SingleRuleMapper(new ActionMapper());

		//when
		Optional<SingleRule> result = singleRuleMapper.toSingleRule(line);

		//then
		Assert.assertTrue(result.isPresent());
		SingleRule rule = result.get();
		Assert.assertTrue(rule.getId() == 1);
		Assert.assertTrue(rule.getSource().equals("43.0.0.0/8"));
		Assert.assertTrue(rule.getDestination().equals("any"));
		Assert.assertTrue(rule.getProtocol().equals("udp/53839,49944,58129,21778"));
		Assert.assertTrue(rule.getAction() == Action.DENY);

	}

	@Test
	public void whenLineNoMatchesProduceEmptyOptional() {
		//given
		String line = "1 from2 43.0.0.0/8 to any with udp/53839,49944,58129,21778 => deny";
		SingleRuleMapper singleRuleMapper = new SingleRuleMapper(new ActionMapper());

		//when
		Optional<SingleRule> result = singleRuleMapper.toSingleRule(line);

		//then
		Assert.assertTrue(!result.isPresent());
	}

}
