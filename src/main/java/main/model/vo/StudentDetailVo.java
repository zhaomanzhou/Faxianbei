package main.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

@ApiModel
public class StudentDetailVo {


    @ApiModelProperty("用户id, /detail/my路径下操作不需要上传此参数")
    private Long id;

    @ApiModelProperty("用户名")
    private String name;

    @ApiModelProperty("学院")
    private String academy;

    @ApiModelProperty("年级专业")
    private String majorAndClass;

    @ApiModelProperty("联系方式")
    private String tel;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("兴趣标签")
    private String interestDirection;

    @ApiModelProperty("头像路径")
    private String imagePath;

    @ApiModelProperty("兴趣标签")
    private String interestTag;


}