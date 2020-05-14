package com.yang.zoushen.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "users_info")
public class UserInfo implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Integer sex;
    private String headImg;
    private String zsNum;
    private String signature;
    private String birthday;
    private Integer experience;
    private Integer deleteFlag;
    private Integer nextExperience;
    private GradeRule gradeRule;

    public UserInfo(RegistVo vo) throws ParseException {
        this.username = vo.getUsername();
        this.password = vo.getPassword();
        this.email = vo.getEmail();
        this.sex = vo.getSex();
        this.birthday = vo.getBirthday();
        this.zsNum = "zs_" + new Date().getTime();
        this.deleteFlag = 0;
    }
}
