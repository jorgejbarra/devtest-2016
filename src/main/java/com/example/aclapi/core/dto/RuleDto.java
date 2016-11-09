package com.example.aclapi.core.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RuleDto {
	@JsonProperty("id")
	private int		id;
	@JsonProperty("source")
	private String	source;
	@JsonProperty("destination")
	private String	destination;
	@JsonProperty("protocol")
	private String	protocol;
	@JsonProperty("action")
	private String	action;
}
