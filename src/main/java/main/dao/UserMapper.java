package main.dao;

import main.model.po.User;

public interface UserMapper {

    Long insertAccount(User u);
    
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    long insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    String getPasswordByUsername(String username);

    User getUserByUserName(String username);
}