package com.gyx.service;

import com.gyx.dao.UserDao;
import com.gyx.entity.User;

import javax.servlet.http.HttpSession;

public class UserService {
    private UserDao userDao = new UserDao();

    public boolean registerUser(User user) {
        int row = userDao.registerUser(user);
        return row > 0;

    }

    public boolean loggingUser(User user, HttpSession session) {
        User newUser = userDao.loggingUser(user);
        if (newUser!=null){
            session.setAttribute("user",newUser);
            return true;
        }
        return false;
    }
}
