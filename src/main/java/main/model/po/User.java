package main.model.po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User{
    
    private Long id;

    private String name;

    private String password;

    private Long detailId;

    private Date registerTime;


}