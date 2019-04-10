package main.service;

import main.dao.ChatMapper;
import main.dao.UserMapper;
import main.model.po.Chat;
import main.model.vo.ChatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void addOne(Chat chat)
    {
        chatMapper.insertSelective(chat);
    }

    public Map<String, List<ChatVo>> getMyAll(Long uid)
    {

        String myName = userMapper.selectByPrimaryKey(uid).getName();
        List<Chat> myAll = chatMapper.getMyAll(uid);
        List<ChatVo> collect = myAll.stream()
                .sorted(Comparator.comparing(Chat::getSendTime, Date::compareTo))
                .map(this::changeToVO)
                .collect(Collectors.toList());

        Map<String, List<ChatVo>> result = new HashMap<>();
        for(ChatVo chatVo: collect)
        {
            List<ChatVo> list1 = result.get(getName(chatVo, myName));
            if(list1 == null)
            {
                List<ChatVo> list = new ArrayList<>();
                list.add(chatVo);
                result.put(getName(chatVo, myName), list);
            }else
            {
                list1.add(chatVo);
            }
        }
        return result;
    }

    private String getName(ChatVo c, String myName)
    {
        return c.getFrom().equals(myName)? c.getTo(): c.getFrom();
    }

    private ChatVo changeToVO(Chat chat)
    {
        ChatVo chatVo = new ChatVo();
        chatVo.setMsg(chat.getMsg());
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd: hh-mm");
        chatVo.setSendTime(sdf.format(chat.getSendTime()));
        chatVo.setFrom(userMapper.selectByPrimaryKey(chat.getFromid()).getName());
        chatVo.setTo(userMapper.selectByPrimaryKey(chat.getToid()).getName());

        return chatVo;
    }

}
