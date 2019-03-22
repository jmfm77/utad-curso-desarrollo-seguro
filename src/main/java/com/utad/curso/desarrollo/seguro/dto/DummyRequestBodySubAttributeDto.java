package com.utad.curso.desarrollo.seguro.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DummyRequestBodySubAttributeDto {

    @NotBlank
    private String subAttribute1;

    @NotNull
    @Min(1)
    @Max(10)
    private Long subAttribute2;

    public String getSubAttribute1() {
        return subAttribute1;
    }

    public void setSubAttribute1(
            String subAttribute1) {
        this.subAttribute1 = subAttribute1;
    }

    public Long getSubAttribute2() {
        return subAttribute2;
    }

    public void setSubAttribute2(
            Long subAttribute2) {
        this.subAttribute2 = subAttribute2;
    }

}
