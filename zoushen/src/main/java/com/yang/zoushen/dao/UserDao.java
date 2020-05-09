package com.yang.zoushen.dao;

import com.yang.zoushen.domain.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface UserDao extends Mapper<UserInfo> {

    /**
     * 根据用户名查询下一等级所需经验
     * @param username
     * @return
     */
    int findNextExperienceByUsername(String username);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    List<UserInfo> findUserByName(String username);

    /**
     * 添加一条数据
     * @param userInfo
     * @return
     */
    int insertByUser(UserInfo userInfo);


}
