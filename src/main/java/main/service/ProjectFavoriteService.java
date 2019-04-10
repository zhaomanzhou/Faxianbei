package main.service;

import main.dao.ProjectFavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectFavoriteService {

    @Autowired
    private ProjectFavoriteMapper favoriteMapper;


    public void addFavorite(Long pid, Long uid)
    {
        favoriteMapper.addFavorite(pid, uid);
    }



    public void cancelFavorite(Long fid)
    {
        favoriteMapper.cancelFavorite(fid);
    }

    public List<Long> getMy(Long id)
    {
        List<Long> my = favoriteMapper.getMy(id);
        return my;
    }
}
