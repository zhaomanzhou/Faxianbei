package main.dao;

import main.model.po.Chat;

import java.util.List;

public interface ChatMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(Chat record);

    public List<Chat> getMyAll(Long uid);
    
    
    int changeStatus(Long id);

    int insertSelective(Chat record);

    Chat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Chat record);

    int updateByPrimaryKey(Chat record);
}