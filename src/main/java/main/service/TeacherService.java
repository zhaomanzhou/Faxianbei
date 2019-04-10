package main.service;


import main.dao.TeacherMapper;
import main.model.po.Teacher;
import main.model.po.TeacherSimple;
import main.model.vo.TeacherSimpleVo;
import main.model.vo.TeacherVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static java.util.stream.Collectors.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherMapper tMapper;




    public Map<String, List<TeacherSimpleVo>>  queryAllSimple()
    {
        List<TeacherSimple> teacherSimples = tMapper.selectAllSimple();
        //按头衔分类
        Map<String, List<TeacherSimpleVo>> collects = teacherSimples.stream().map(this::changeToVo)
                .collect(groupingBy(TeacherSimpleVo::getRank));
        return collects;

    }

    public TeacherVo queryById(long id)
    {
        Teacher teacher = tMapper.selectByPrimaryKey(id);
        return changeToVo(teacher);

    }


    private TeacherVo changeToVo(Teacher t)
    {
        if(t ==null)
            return null;
        TeacherVo tv = new TeacherVo();
        BeanUtils.copyProperties(t, tv);
        return tv;
    }



    private TeacherSimpleVo changeToVo(TeacherSimple t)
    {
        if(t ==null)
            return null;
        TeacherSimpleVo teacherSimpleVo = new TeacherSimpleVo();
        BeanUtils.copyProperties(t, teacherSimpleVo);
        return teacherSimpleVo;
    }


}
