package main.model.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ChatVo {
    
    private String to;

    private String from;

    private String msg;

    private String sendTime;


}