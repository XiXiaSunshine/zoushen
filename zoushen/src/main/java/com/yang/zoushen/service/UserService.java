package com.yang.zoushen.service;

import com.yang.zoushen.domain.UserInfo;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface UserService {
    int findNextExperienceByUsername(String username);

    public List<UserInfo> findUserByName(String username) throws SQLException, ParseException;

    int addByUser(UserInfo userInfo) throws SQLException;
}
