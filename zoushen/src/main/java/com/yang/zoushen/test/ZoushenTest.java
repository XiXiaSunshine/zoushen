package com.yang.zoushen.test;

import com.yang.zoushen.dao.UserDao;
import com.yang.zoushen.domain.UserInfo;
import com.yang.zoushen.web.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class ZoushenTest {
    @Test
    public void test01() {

    }
}
