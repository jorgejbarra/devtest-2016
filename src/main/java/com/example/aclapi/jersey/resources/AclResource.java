package com.example.aclapi.jersey.resources;

import java.util.Optional;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.aclapi.core.controller.AclResourceController;
import com.example.aclapi.core.dto.RuleDto;
import com.example.aclapi.core.dto.RuleFilterParam;
import com.example.aclapi.core.factories.ControllerFactory;
import com.example.aclapi.core.util.RuleFilterParamValidator;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Path("acl")
@AllArgsConstructor
@RequiredArgsConstructor
public class AclResource {

	private AclResourceController		controller					= ControllerFactory.createAclResourceController();
	private RuleFilterParamValidator	ruleFilterParamValidator	= new RuleFilterParamValidator();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAclList(@BeanParam RuleFilterParam filter) {

		if (ruleFilterParamValidator.isEmpty(filter)) {
			return controller.findAll();
		} else {
			Optional<RuleDto> foundRule = controller.findFirstMatch(filter);
			if (foundRule.isPresent()) {
				return foundRule.get();
			} else {
				throw new NotFoundException();
			}

		}
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public RuleDto getAclById(@PathParam("id") int id) {
		Optional<RuleDto> foundRule = controller.findOneById(id);
		if (foundRule.isPresent()) {
			return foundRule.get();
		} else {
			throw new NotFoundException();
		}
	}
}
