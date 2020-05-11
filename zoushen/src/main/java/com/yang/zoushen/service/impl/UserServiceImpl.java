package com.yang.zoushen.service.impl;

import com.yang.zoushen.dao.UserDao;
import com.yang.zoushen.domain.UserInfo;
import com.yang.zoushen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int findNextExperienceByUsername(String username){
        return userDao.findNextExperienceByUsername(username);
    }

    @Override
    public List<UserInfo> findUserByName(String username) throws SQLException, ParseException {
        return userDao.findUserByName(username);
    }

    @Override
    public int addByUser(UserInfo userInfo) throws SQLException {
        if (userInfo == null){
            return -1;
        }
        return userDao.insertByUser(userInfo);
    }

    @Override
    public List<UserInfo> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public List<UserInfo> findByLevel(String level) {
        return userDao.findByLevel(level);
    }
}
