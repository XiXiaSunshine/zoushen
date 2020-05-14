package com.yang.test.test;

import com.yang.test.mapper.GradeMapper;
import com.yang.test.mapper.UserMapper;
import com.yang.test.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected SqlSession sqlSession = null;
    protected UserMapper userMapper = null;
    protected GradeMapper gradeMapper = null;

    @Before
    public void init(){
        sqlSession = MybatisUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        gradeMapper = sqlSession.getMapper(GradeMapper.class);
    }

    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }
}
