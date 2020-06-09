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
    @Length(min = 1, max = 18, message = "身份证号长度范围在1~18个字符")
    private String idNum;
    @NotNull
    @Length(min = 1, max = 20, message = "姓名长度范围在1~20个字符")
    private String namee;
    @NotNull
    @Length(min = 1, max = 11, message = "电话号码长度范围在1~11个字符")
    private String telephone;
    private Integer appointNum;
    private Integer placeId;
}
