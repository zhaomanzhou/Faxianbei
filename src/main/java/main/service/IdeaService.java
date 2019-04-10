package main.service;

import main.dao.IdeaMapper;
import main.model.po.Idea;
import main.model.vo.IdeaVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IdeaService {

    @Autowired
    private SimpleDateFormat format;

    @Autowired
    private IdeaMapper mapper;
    public List<IdeaVo> selectAll(Long id)
    {
        List<Idea> ideas = mapper.selectAll(id);
        List<IdeaVo> collect = ideas.stream()
                .sorted(Comparator.comparing(Idea::getRecordTime, Date::compareTo))
                .map(this::changeToVo)
                .collect(Collectors.toList());
        return collect;
    }



    public IdeaVo selkectById(Long id)
    {
        return changeToVo(mapper.selectByPrimaryKey(id));
    }


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void add(IdeaVo ideaVo, Long userId )
    {
        Idea idea = changeToPo(ideaVo);
        idea.setPersonId(userId);
        mapper.insertSelective(idea);
    }

    public IdeaVo changeToVo(Idea i)
    {
        IdeaVo iv = new IdeaVo();
        BeanUtils.copyProperties(i, iv);
        iv.setRecordTime(format.format(i.getRecordTime()));
        return iv;
    }

    public Idea changeToPo(IdeaVo ideaVo)
    {
        Idea idea = new Idea();
        BeanUtils.copyProperties(ideaVo, idea);
        idea.setId(null);
        idea.setRecordTime(null);
        return idea;
    }
}
