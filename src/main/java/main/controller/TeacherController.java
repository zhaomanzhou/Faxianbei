package main.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import main.model.vo.ProjectPublicSimpleVo;
import main.model.vo.TeacherSimpleVo;
import main.model.vo.TeacherVo;
import main.service.TeacherService;
import main.util.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "导师信息相关接口", description = "/teacher")
@RestController
@RequestMapping("/teacher")
public class TeacherController extends ExceptionController {

    @Autowired
    private TeacherService teacherService;


    @ApiOperation("简略方式查看导师信息")
    @ApiResponses(
            @ApiResponse(code = 200, message = "data数据   Map<老师头衔, List<老师信息>>", response = TeacherSimpleVo.class)
    )
    @GetMapping("/simple")
    public CommonReturnType queryAllSimple()
    {
        Map<String, List<TeacherSimpleVo>> stringListMap = teacherService.queryAllSimple();

        return CommonReturnType.ok(stringListMap);
    }


    @ApiOperation("查询具体导师信息")
    @ApiResponses(
            @ApiResponse(code = 200, message = "Ok", response = TeacherVo.class)
    )
    @GetMapping("/{id}")
    public CommonReturnType queryById(@PathVariable long id)
    {
        TeacherVo teacherVo = teacherService.queryById(id);
        if(teacherVo == null)
        {
            return CommonReturnType.errorMsg("不存在");
        }

        return CommonReturnType.ok(teacherVo);
    }




}
