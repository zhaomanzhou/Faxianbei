package main.dao;

import main.model.po.ProjectPublic;
import main.model.po.ProjectPublicSimple;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectPublicMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(ProjectPublic record);

    int insertSelective(ProjectPublic record);

    ProjectPublic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectPublic record);

    int updateByPrimaryKeyWithBLOBs(ProjectPublic record);

    int updateByPrimaryKey(ProjectPublic record);

    List<ProjectPublicSimple> queryAllSimple();


    void changeStatus(@Param("pid") int pid, @Param("status") int status);

    public List<ProjectPublic> qureyMyProject(Long uid);

}