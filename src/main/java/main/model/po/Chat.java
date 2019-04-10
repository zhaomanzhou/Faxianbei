package main.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class Chat {
    private Long id;
    private Long fromid;
    private Long toid;
    private String msg;
    private Date sendTime;
    private int isRead;
}
