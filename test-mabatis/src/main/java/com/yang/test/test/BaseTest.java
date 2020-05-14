package com.yang.test.test;

import com.yang.test.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected SqlSession sqlSession = null;

    @Before
    public void init(){
        sqlSession = MybatisUtils.getSqlSession();
    }

    @After
    public void destroy(){
        sqlSession.commit();
        sqlSession.close();
    }
}
