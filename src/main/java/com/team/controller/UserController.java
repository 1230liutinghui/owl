package com.team.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.team.entity.User;
import com.team.service.UserService;
import com.team.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("save")
    public Result save(@RequestBody User user) {
        Result result = new Result();
        try {
            userService.save(user);
            result.setMessage("用户信息保存成功");
        } catch (Exception e) {
            result.setStatus(false);
            result.setMessage("保存用户信息失败");
        }
        return result;
    }

    //分页查询
    @GetMapping("findByPage")
    public Map<String, Object> findByPage(Integer pageCurrent, Integer rows) {
        Map<String, Object> result = new HashMap<>();
        pageCurrent = pageCurrent == null ? 1 : pageCurrent;
        rows = rows == null ? 5 : rows;

        List<User> userList = userService.findByPage(pageCurrent, rows);
        Long total = userService.findTotal();
        result.put("userList", userList);
        result.put("total", total);
        return result;
    }
}
