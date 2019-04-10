package main.dao;

import main.model.po.Idea;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IdeaMapperTest {

    @Autowired
    private IdeaMapper mapper;

    @Autowired
    private SimpleDateFormat format;

    @Test
    public void test01()
    {
        List<Idea> ideas = mapper.selectAll(1000L);
        System.out.println(ideas);
        format.format(ideas.get(0).getRecordTime());
    }

}