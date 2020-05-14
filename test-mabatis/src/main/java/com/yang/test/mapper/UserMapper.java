package com.yang.test.mapper;

import com.yang.test.domain.UserInfo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UserInfo> {

    UserInfo findById(Integer id);

    int insert(UserInfo userInfo);

    List<UserInfo> findByLikeName(String name);

    Integer findNextExperienceByUsername(String username);

    List<UserInfo> findUserByName(@Param("username") String username);

    List<UserInfo> findByLevelAndExp(@Param("level") String level,@Param("exp") Integer exp);
}
