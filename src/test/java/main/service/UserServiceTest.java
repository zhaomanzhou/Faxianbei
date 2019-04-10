package main.service;

import main.model.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void insertUser() {
        userService.insertUser("王五","987");
    }

    @Test
    public void test02()
    {
        User tom = userService.getUserByUserName("tom");
        System.out.println(tom);
    }

    @Test
    public void test03()
    {
        redisTemplate.opsForValue().set("k11", "v1");
        Object k1 = redisTemplate.opsForValue().get("k11");
        System.out.println(k1);
    }

}