package main.dao;

import main.model.po.StudentDetail;

public interface StudentDetailMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(StudentDetail record);

    int insertSelective(StudentDetail record);

    StudentDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StudentDetail record);

    int updateByPrimaryKey(StudentDetail record);

    int updateByUserIdSelective(StudentDetail record);
}