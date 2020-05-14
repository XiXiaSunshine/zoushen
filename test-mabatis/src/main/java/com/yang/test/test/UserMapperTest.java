package com.yang.test.test;

import com.yang.test.mapper.UserMapper;
import com.yang.test.domain.UserInfo;
import org.junit.Test;

import java.util.List;

public class UserMapperTest extends BaseTest {
    private UserMapper dao;

    @Test
    public void testSelectByUsername(){
        dao = sqlSession.getMapper(UserMapper.class);
        String username = "走神";
        List<UserInfo> us = dao.findUserByName(username);
        System.out.println(us);
    }

    @Test
    public void testSelectById(){
        dao = sqlSession.getMapper(UserMapper.class);
        List<UserInfo> userInfos = dao.selectAll();
        System.out.println(userInfos);
    }
}
