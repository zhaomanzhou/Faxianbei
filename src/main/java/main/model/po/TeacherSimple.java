package main.model.po;


import lombok.Data;

@Data
public class TeacherSimple {
    private Long id;

    private String name;

    private String rank;

    private String school;

    private String direction;

    private String logoPath;
}
