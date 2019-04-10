package main.dao;

import main.model.po.ProjectPublicSimple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProjectPublicMapperTest {

    @Autowired
    private ProjectPublicMapper projectPublicMapper;

    @Test

    public void testQueryAllSimple()
    {
        List<ProjectPublicSimple> projectPublicSimples = projectPublicMapper.queryAllSimple();
        System.out.println(projectPublicSimples);
    }

}