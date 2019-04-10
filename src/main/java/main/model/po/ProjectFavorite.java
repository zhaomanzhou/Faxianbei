package main.model.po;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectFavorite {
    
    private Long id;

    private Long projectId;

    private Long personId;

    private Date collectTime;

}