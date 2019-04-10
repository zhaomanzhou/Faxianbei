package main.model.vo;


import lombok.Data;

/**
 * 变化  Date被处理
 * is_show不展示
 * establish变为bool
 */

@Data
public class ProjectPublicVo {
    
    private Long id;

    private String publisher;

    private String logoPath;

    private String publishDate;

    private String title;

    private String tinyDescription;

    private String catalog;

    private String academy;

    private String caption;

    private String direction;

    private String type;

    private Byte totalNum;

    private Byte curNum;

    private String technology;

    private boolean establish;

    private String detailDescription;


}