package com.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.dto.TestValueDto;

@Path("combinedAnnotations")
public class JsonResource {

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public TestValueDto getAccount() {
		return new TestValueDto(12);
	}
}
