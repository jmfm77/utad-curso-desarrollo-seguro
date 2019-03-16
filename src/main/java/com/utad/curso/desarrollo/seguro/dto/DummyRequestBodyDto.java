package com.utad.curso.desarrollo.seguro.dto;

import java.util.List;

public class DummyRequestBodyDto {

	private String attribute1;

	private Long attribute2;

	private DummyRequestBodySubAttribute attribute3;

	private List<String> attribute4;

	private List<DummyRequestBodySubAttribute> attribute5;

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public Long getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(Long attribute2) {
		this.attribute2 = attribute2;
	}

	public DummyRequestBodySubAttribute getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(DummyRequestBodySubAttribute attribute3) {
		this.attribute3 = attribute3;
	}

	public List<String> getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(List<String> attribute4) {
		this.attribute4 = attribute4;
	}

	public List<DummyRequestBodySubAttribute> getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(List<DummyRequestBodySubAttribute> attribute5) {
		this.attribute5 = attribute5;
	}

}