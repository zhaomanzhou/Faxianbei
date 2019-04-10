package main.model.vo;


import lombok.Data;

@Data
public class TeacherSimpleVo {
    private Long id;

    private String name;

    private String rank;

    private String school;

    private String direction;

    private String logoPath;
}
