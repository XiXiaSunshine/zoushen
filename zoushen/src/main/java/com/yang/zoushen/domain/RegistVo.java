package com.yang.zoushen.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

@Data
public class RegistVo {
    @NotEmpty(message = "用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @Email(message = "邮箱格式有误")
    private String email;
    @Pattern(regexp = "[0|1]{1}")
    private int sex;
    @Past(message = "出生日期不得早于当前日期")
    private String birthday;
}
