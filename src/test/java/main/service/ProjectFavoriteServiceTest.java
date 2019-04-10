package main.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectFavoriteServiceTest {

    @Autowired
    private ProjectFavoriteService favoriteService;

    @Test
    public void testAdd()
    {
        favoriteService.addFavorite(1000L, 1000L);
    }
}