package main.service;

import com.github.pagehelper.PageHelper;
import main.dao.ProjectPublicMapper;
import main.dao.UserMapper;
import main.model.po.ProjectPublic;
import main.model.po.ProjectPublicSimple;
import main.model.po.User;
import main.model.vo.ProjectPublicSimpleVo;
import main.model.vo.ProjectPublicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectPublicService {


    @Autowired
    private ProjectPublicMapper projectMapper;

    @Autowired
    private SimpleDateFormat dateFormat;

    @Autowired
    private UserMapper userMapper;


    public List<ProjectPublicSimpleVo> querySimple(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProjectPublicSimple> projectPublicSimples = projectMapper.queryAllSimple();
        List<ProjectPublicSimpleVo> collects = projectPublicSimples.stream().map(p -> changeToVo(p)).collect(Collectors.toList());
        return collects;
    }



    public ProjectPublicVo queryById(Long id)
    {
        ProjectPublic project = projectMapper.selectByPrimaryKey(id);
        ProjectPublicVo projectPublicVo = changeToVo(project);
        return projectPublicVo;

    }

    public List<ProjectPublicVo> qureyMyProject(Long uid)
    {
        List<ProjectPublic> projectPublics = projectMapper.qureyMyProject(uid);
        List<ProjectPublicVo> collect = projectPublics.stream()
                .map(this::changeToVo)
                .collect(Collectors.toList());
        return collect;
    }



    public void updateSelective(ProjectPublic record)
    {

        projectMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void changeStatus(int pid, int status)
    {
        projectMapper.changeStatus(pid, status);
    }



    private ProjectPublicSimpleVo changeToVo(ProjectPublicSimple p)
    {
        ProjectPublicSimpleVo pv = new ProjectPublicSimpleVo();
        BeanUtils.copyProperties(p, pv);
        pv.setPublishDate(dateFormat.format(p.getPublishDate()));
        return pv;
    }

    private ProjectPublicVo changeToVo(ProjectPublic p)
    {
        ProjectPublicVo pv = new ProjectPublicVo();
        BeanUtils.copyProperties(p, pv);
        pv.setPublishDate(dateFormat.format(p.getPublishDate()));
        pv.setEstablish(p.getEstablish() == 1);
        User user = userMapper.selectByPrimaryKey(p.getsId());
        pv.setPublisher(user.getName());
        return pv;
    }

}
