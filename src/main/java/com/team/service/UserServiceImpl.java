package com.team.service;

import com.team.dao.UserDao;
import com.team.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public List<User> findByPage(Integer pageCurrent, Integer rows) {
        int start = (pageCurrent - 1) * rows;
        return userDao.findByPage(start, rows);
    }

    @Override
    public Long findTotal() {
        return userDao.findTotal();
    }
}
