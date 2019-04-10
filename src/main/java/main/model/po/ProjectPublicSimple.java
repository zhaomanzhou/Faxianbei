package main.model.po;


import lombok.Data;

@Data
public class ProjectPublicSimple {

    private Integer id;
    private String publisher;
    private String logoPath;
    private String title;
    private String tinyDescription;
    private java.util.Date publishDate;

}
