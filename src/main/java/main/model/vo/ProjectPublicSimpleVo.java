package main.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@ApiModel
public class ProjectPublicSimpleVo {

    @ApiModelProperty("项目id")
    private Integer id;
    @ApiModelProperty("发布者")
    private String publisher;
    @ApiModelProperty("logo地址")
    private String logoPath;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("简述")
    private String tinyDescription;
    @ApiModelProperty("发布日期")
    private String publishDate;

}
