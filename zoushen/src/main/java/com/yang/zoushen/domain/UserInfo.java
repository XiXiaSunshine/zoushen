package com.yang.zoushen.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
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
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "sex")
    private Integer sex;
    @Column(name = "headImg")
    private String headImg;
    @Column(name = "zsNum")
    private String zsNum;
    @Column(name = "birthday")
    private String birthday;
    @Column(name = "experience")
    private Integer experience;
    @Column(name = "deleteFlag")
    private Integer deleteFlag;
    @Transient
    private String level;
    @Transient
    private Integer nextExperience;

    public UserInfo(Integer id, String username, String password, String email, Integer sex, String headImg, String zsNum, String birthday, Integer experience, Integer deleteFlag, String level, Integer nextExperience) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.headImg = headImg;
        this.zsNum = zsNum;
        this.birthday = birthday;
        this.experience = experience;
        this.deleteFlag = deleteFlag;
        this.level = level;
        this.nextExperience = nextExperience;
    }

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
