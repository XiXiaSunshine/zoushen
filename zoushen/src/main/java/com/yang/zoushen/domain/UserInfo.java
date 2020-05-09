package com.yang.zoushen.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserInfo implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private int sex;
    private String headImg;
    private String zsNum;
    private String birthday;
    private int experience;
    private int delete;
    private String level;
    @TableField(exist = false)
    private int nextExperience;

    public UserInfo(int id, String username, String password, String email, int sex,
                    String headImg, String zsNum, String birthday, int experience, int delete, String level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.sex = sex;
        this.headImg = headImg;
        this.zsNum = zsNum;
        this.birthday = birthday;
        this.experience = experience;
        this.delete = delete;
        this.level = level;
    }

    public UserInfo(RegistVo vo) throws ParseException {
        this.username = vo.getUsername();
        this.password = vo.getPassword();
        this.email = vo.getEmail();
        this.sex = vo.getSex();
        this.birthday = vo.getBirthday();
        this.zsNum = "zs_" + new Date().getTime();
        this.delete = 0;
    }
}
