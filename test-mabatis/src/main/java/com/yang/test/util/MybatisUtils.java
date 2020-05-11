package com.yang.test.util;

import com.yang.test.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            MapperHelper mapperHelper = new MapperHelper();
            Config config = new Config();
            List<Class> mappers = new ArrayList<>();

            mappers.add(UserMapper.class);

            config.setIdentity("MYSQL");
//            config.setCheckExampleEntityClass(true);
//            config.setUseSimpleType(true);
//            config.setEnableMethodAnnotation(true);
//            config.setUseJavaType(true);
//            config.setMappers(mappers);

            mapperHelper.setConfig(config);
            mapperHelper.processConfiguration(sqlSessionFactory.getConfiguration());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    public static void close(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
    }
}
