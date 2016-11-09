package com.example.aclapi.core.util;

import java.util.function.Predicate;

import com.example.aclapi.core.domain.Action;
import com.example.aclapi.core.domain.Rule;

import lombok.Builder;

@Builder
public class FindRulePredicate implements Predicate<Rule> {

	private Integer	id;
	private String	source;
	private String	destination;
	private String	protocol;
	private Action	action;

	@Override
	public boolean test(Rule rule) {

		boolean match = true;
		if (id != null) {
			match = match && rule.getId() == id.intValue();
		}

		if (source != null) {
			match = match && rule.getSource().equals(source);
		}

		if (destination != null) {
			match = match && rule.getDestination().equals(destination);
		}

		if (protocol != null) {
			match = match && rule.getProtocol().equals(protocol);
		}

		if (action != null) {
			match = match && rule.getAction().equals(action);
		}

		return match;
	}

}
