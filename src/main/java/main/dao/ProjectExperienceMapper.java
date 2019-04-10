package main.dao;

import main.model.po.ProjectExperience;

public interface ProjectExperienceMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(ProjectExperience record);

    int insertSelective(ProjectExperience record);

    ProjectExperience selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectExperience record);

    int updateByPrimaryKey(ProjectExperience record);
}