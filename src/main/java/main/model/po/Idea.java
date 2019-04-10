package main.model.po;

import lombok.Data;

import java.util.Comparator;
import java.util.Date;

@Data
public class Idea implements Comparator<Idea> {
    
    private Long id;

    private Long personId;

    private Date recordTime;

    private String name;

    private String description;

    private String meaning;


    @Override
    public int compare(Idea o1, Idea o2) {
        return o1.getRecordTime().compareTo(o2.getRecordTime());
    }
}