package main;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDatabase {


    @Value("${lll}")
    private int testData;

    @Value("#{1+2}")
    private int temp;


    @Test
    public void test()
    {
        System.out.println(testData);
        System.out.println(temp);
    }

}
