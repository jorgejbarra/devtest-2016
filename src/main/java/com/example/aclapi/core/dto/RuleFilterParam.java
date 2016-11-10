package com.example.aclapi.core.dto;

import javax.ws.rs.QueryParam;

import lombok.Data;

@Data
public class RuleFilterParam {
	@QueryParam("id")
	private Integer	id;
	@QueryParam("source")
	private String	source;
	@QueryParam("destination")
	private String	destination;
	@QueryParam("protocol")
	private String	protocol;
	@QueryParam("action")
	private String	action;
}
