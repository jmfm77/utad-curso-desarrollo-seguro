package com.utad.curso.desarrollo.seguro.controller.api;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utad.curso.desarrollo.seguro.dto.DummyRequestBodyDto;
import com.utad.curso.desarrollo.seguro.dto.DummyRequestBodySubAttribute;
import com.utad.curso.desarrollo.seguro.dto.DummyResponseDto;

/**
 * Controlador API REST de prueba.
 * 
 * @author Juanjo
 *
 */
@RestController
@RequestMapping("/api/dummy")
@Validated
public class DummyApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/dummy-get/{path-var1}/otra-cosa/{path-var2}")
	public DummyResponseDto get(
			@RequestParam(name = "param1", required = false, defaultValue = "value") @Email String param1,
			@RequestParam(name = "param2", required = true) @NotNull Long param2,
			@PathVariable(name = "path-var1", required = true) @Pattern(regexp = "[0-9]") String param3,
			@PathVariable(name = "path-var2", required = true) @NotBlank String param4) {

		logger.info("Request: GET /api/dummy/dummy-get; param1: {}", param1);
		logger.info(param2.toString());

		DummyResponseDto response = new DummyResponseDto();

		if (param1.equals("hola")) {
			response.setSuccess(true);
		} else {
			response.setSuccess(false);
		}

		return response;

	}

	@PostMapping("/dummy-post")
	public DummyResponseDto post(@RequestBody(required = true) @Valid DummyRequestBodyDto body) {

		logger.info("Request: POST /api/dummy/dummy-post");
		logger.info(body.getAttribute1());
		logger.info(body.getAttribute2().toString());
		logger.info(body.getAttribute3().getSubAttribute1());

		for (String str : body.getAttribute4()) {
			logger.info(str);
		}

		for (DummyRequestBodySubAttribute subAttribute : body.getAttribute5()) {
			logger.info(subAttribute.getSubAttribute1());
			logger.info(subAttribute.getSubAttribute2().toString());
		}

		DummyResponseDto response = new DummyResponseDto();
		response.setSuccess(true);

		return response;

	}

}