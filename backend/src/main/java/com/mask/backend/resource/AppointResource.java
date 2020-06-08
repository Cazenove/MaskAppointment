package com.mask.backend.resource;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 注册参数
 */
@Data
public class AppointResource {
    @NotNull
    @Length(min = 1, max = 18)
    private String idNum;
    @NotNull
    @Length(min = 1, max = 20)
    private String namee;
    @NotNull
    @Length(min = 1, max = 11)
    private String telephone;
    private Integer appointNum;
    private Integer placeId;
}
