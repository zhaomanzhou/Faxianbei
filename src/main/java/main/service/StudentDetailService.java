package main.service;


import main.dao.StudentDetailMapper;
import main.dao.UserMapper;
import main.model.po.StudentDetail;
import main.model.po.User;
import main.model.vo.StudentDetailVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentDetailService {
    @Autowired
    private StudentDetailMapper detailMapper;

    @Autowired
    private UserMapper um;


    public int insert(StudentDetail sd)
    {
        return detailMapper.insert(sd);
    }

    /**
     *
     * @param id 用户的id 不是detail的id
     * @return
     */

    public StudentDetailVo selectById(Long id)
    {
        User user = um.selectByPrimaryKey(id);

        StudentDetail studentDetail = detailMapper.selectByPrimaryKey(user.getDetailId());
        StudentDetailVo sdv = new StudentDetailVo();
        BeanUtils.copyProperties(studentDetail, sdv);
        sdv.setId(user.getId());
        sdv.setName(user.getName());
        return sdv;

    }


    public void updateByUserIdSelective(StudentDetail record)
    {
        detailMapper.updateByUserIdSelective(record);
    }

    @Transactional(isolation= Isolation.READ_COMMITTED)
    public void updateUser(StudentDetail studentDetail)
    {
        User user = um.selectByPrimaryKey(studentDetail.getUserId());
        StudentDetail sd = new StudentDetail();
        BeanUtils.copyProperties(studentDetail, sd);
        sd.setUserId(null);
        sd.setId(user.getDetailId());
        detailMapper.updateByPrimaryKeySelective(sd);
    }


}
