package com.utad.curso.desarrollo.seguro.dto;

import javax.validation.Valid;
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

	@GetMapping("/dummy-get/{path-var1}/something/{path-var2}")
	public DummyResponseDto get(
			@RequestParam(name = "param1", required = false, defaultValue = "value") @NotBlank String param1,
			@RequestParam(name = "param2", required = true) @NotNull Long param2,
			@PathVariable(name = "path-var1", required = true) @NotBlank @Pattern(regexp = "[0-9]") String param3,
			@PathVariable(name = "path-var2", required = true) @NotBlank String param4) {

		logger.info("Request: GET /api/dummy/dummy-get ");
		logger.info(param1);
		logger.info(param2.toString());
		logger.info(param3);
		logger.info(param4);

		DummyResponseDto response = new DummyResponseDto();
		response.setSuccess(true);

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

		for (DummyRequestBodySubAttributeDto subAttribute : body.getAttribute5()) {
			logger.info(subAttribute.getSubAttribute1());
			logger.info(subAttribute.getSubAttribute2().toString());
		}

		DummyResponseDto response = new DummyResponseDto();
		response.setSuccess(true);

		return response;

	}

}
