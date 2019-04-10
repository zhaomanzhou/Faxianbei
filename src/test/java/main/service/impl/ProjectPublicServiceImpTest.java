package main.service.impl;

import main.model.po.ProjectPublicSimple;
import main.model.vo.ProjectPublicSimpleVo;
import main.service.ProjectPublicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectPublicServiceImpTest {


    @Autowired
    private ProjectPublicService serviceImp;

    @Test
    public void querySimple() {
        List<ProjectPublicSimpleVo> projectPublicSimpleVos = serviceImp.querySimple(2, 2);

        System.out.println(projectPublicSimpleVos);
    }
}