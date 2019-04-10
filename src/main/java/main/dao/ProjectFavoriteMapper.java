package main.dao;

import main.model.po.ProjectFavorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectFavoriteMapper {


    void addFavorite(@Param("pid") Long pid, @Param("uid") Long uid);

    public void cancelFavorite(Long fid);

    public List<Long> getMy(Long id);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectFavorite record);

    int insertSelective(ProjectFavorite record);

    ProjectFavorite selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectFavorite record);

    int updateByPrimaryKey(ProjectFavorite record);
}