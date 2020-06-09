package com.mask.backend.resource;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class QueryResource {
    @NotNull
    @Length(min = 1, max = 11, message = "电话号码长度范围在1~11个字符")
    private String telephone;
}
