package main.dao;

import main.model.po.Teacher;
import main.model.po.TeacherSimple;

import java.util.List;

public interface TeacherMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<TeacherSimple> selectAllSimple();
}