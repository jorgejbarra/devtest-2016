package com.example.aclapi.core.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Rule {

	private int		id;
	private String	source;
	private String	destination;
	private String	protocol;
	private Action	action;

}
