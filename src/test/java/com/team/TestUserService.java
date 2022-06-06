package com.team;

import com.team.entity.User;
import com.team.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

import java.util.Date;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("王五");
        user.setBir(new Date());
        user.setAddress("上海市闵行区");
        user.setSex("男");

        userService.save(user);
    }

    @Test
    public void testFindAll() {
        userService.findAll().forEach(user -> System.out.println("user=" + user));
    }
}
