package com.yang.test.mapper;

import com.yang.test.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UserInfo> {
    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    List<UserInfo> findUserByName(@Param("username") String username);
}
