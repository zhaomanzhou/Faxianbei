package main.dao;

import main.model.po.Idea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IdeaMapper {

    List<Idea> selectAll(Long id);

    int deleteByPrimaryKey(Long id);

    int insert(Idea record);

    int insertSelective(Idea record);

    Idea selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Idea record);

    int updateByPrimaryKey(Idea record);

}