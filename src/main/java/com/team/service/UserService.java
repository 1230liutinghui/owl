package com.team.service;

import com.team.entity.User;
import java.util.List;

public interface UserService {

    //查询所有的用户
    List<User> findAll();

    //保存用户信息
    void save(User user);

    //分页查询
    List<User> findByPage(Integer pageCurrent, Integer rows);

    //查询总条数
    Long findTotal();
}
