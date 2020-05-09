package com.yang.zoushen;

import com.yang.zoushen.config.RootConfig;
import com.yang.zoushen.domain.UserInfo;
import com.yang.zoushen.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class AppTest {

    @Autowired
    UserService userService;
    @Test
    public void test01() throws SQLException {
        userService.addByUser(new UserInfo(
                666,"tx","123","123@qq.com",1,
                "default_head.png","zs_tx123346","1997-1-7",
                1000,0,"5"
        ));
    }

    @Test
    public void test02(){

    }
}
