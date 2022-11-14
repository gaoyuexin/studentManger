package com.gyx.dao;

import com.gyx.entity.User;

public class UserDao extends BaseDao<User>{
    public int registerUser(User user) {
        return dml("insert into user values(null,?,?,?)",
                user.getUname(),user.getUsername(),user.getPassword());
    }

    public User loggingUser(User user) {
        return oneLine("select * from user where username = ? and password = ?",
                User.class,user.getUsername(),user.getPassword());
    }
}
