package com.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TestValueDto {

	@JsonProperty("value")
	int x;

}
