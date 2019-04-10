package main.service;

import main.dao.StudentDetailMapper;
import main.dao.UserMapper;
import main.model.po.StudentDetail;
import main.model.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {


    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentDetailMapper detailMapper;

    @Autowired
    private PasswordEncoder encoder;


    public void getUserById(Long id) {
        userMapper.selectByPrimaryKey(id);
    }

    public String getPasswordByUsername(String username)
    {
        return userMapper.getPasswordByUsername(username);
    }

    @Transactional(isolation= Isolation.READ_COMMITTED)
    public void insertUser(String username, String password)
    {
        User u = new User();
        u.setName(username);
        u.setPassword(encoder.encode(password));
        //想用户表插入用户
        userMapper.insertAccount(u);
        Long userId = u.getId();
        log.info("用户表id " + userId);
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setUserId(u.getId());
        detailMapper.insertSelective(studentDetail);
        Long detailId = studentDetail.getId();
        log.info("学生详情用户表 " + detailId);
        u.setDetailId(studentDetail.getId());
        userMapper.updateByPrimaryKeySelective(u);
    }


    public User getUserByUserName(String username)
    {
        return userMapper.getUserByUserName(username);
    }
}

