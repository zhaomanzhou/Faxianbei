package main.dao;

import main.model.po.PublishProjectStatue;

public interface PublishProjectStatueMapper {
    
    int deleteByPrimaryKey(Long id);

    int insert(PublishProjectStatue record);

    int insertSelective(PublishProjectStatue record);

    PublishProjectStatue selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PublishProjectStatue record);

    int updateByPrimaryKey(PublishProjectStatue record);
}