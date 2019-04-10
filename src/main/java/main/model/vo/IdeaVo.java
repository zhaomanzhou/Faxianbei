package main.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class IdeaVo {

    @ApiModelProperty("金点子id, 此参数仅作为返回结果, 上传操作请不要上传次参数")
    private Long id;

    @ApiModelProperty("金点子记录时间")
    private String recordTime;

    @ApiModelProperty("金点子名称")
    private String name;

    @ApiModelProperty("金点子描述")
    private String description;

    @ApiModelProperty("金点子意义")
    private String meaning;

}