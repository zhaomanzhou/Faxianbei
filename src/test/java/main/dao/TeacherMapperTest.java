package main.dao;

import main.model.po.TeacherSimple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testSelectAllSimple()
    {
        List<TeacherSimple> teacherSimples = teacherMapper.selectAllSimple();
        System.out.println(teacherSimples);
    }

}