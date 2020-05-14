package com.yang.test.test;

import com.yang.test.domain.UserInfo;
import org.junit.Test;

import java.util.List;

public class UserMapperTest extends BaseTest {

    @Test
    public void testFindById(){
        UserInfo u = userMapper.findById(1);
        System.out.println(u);
    }
    @Test
    public void testInsert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test");
        userInfo.setPassword("123");
        userInfo.setEmail("123@qq.com");
        userInfo.setSex(1);
        userInfo.setBirthday("1977-1-1");
        userInfo.setZsNum("6666666");

        int insert = userMapper.insert(userInfo);
        System.out.println(userInfo);
    }

    @Test
    public void testselectByLikeName() {
        List<UserInfo> userInfos = userMapper.findByLikeName("a");
        userInfos.forEach(u -> System.out.println(u));
    }

    @Test
    public void testSelectByLevelAndExp() {
        List<UserInfo> userInfos = userMapper.findByLevelAndExp("1", 50);
        userInfos.forEach(u -> {
            Integer nextExp = userMapper.findNextExperienceByUsername(u.getUsername());
            u.setNextExperience(nextExp);
        });

        System.out.println(userInfos);
    }

    @Test
    public void testSelectNextExp() {
        Integer zs = userMapper.findNextExperienceByUsername("走神");
        System.out.println(zs);
    }

    @Test
    public void testSelectByUsername() {
        String username = "走神";
        List<UserInfo> us = userMapper.findUserByName(username);
        System.out.println(us);
    }

    @Test
    public void testSelectById() {
        List<UserInfo> userInfos = userMapper.selectAll();
        System.out.println(userInfos);
    }
}
