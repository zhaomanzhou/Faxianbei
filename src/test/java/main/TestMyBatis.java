package main;


import main.dao.UserMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestMyBatis {


    @Autowired
    private UserMapper um;

    @Before
    public void before()
    {

    }

    @Test
    public void test01()
    {
        Assert.assertNotNull(um);
    }
}

