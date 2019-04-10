package main.controller;


import io.swagger.annotations.*;
import main.model.po.User;
import main.model.vo.ProjectPublicSimpleVo;
import main.model.vo.ProjectPublicVo;
import main.service.ProjectPublicService;
import main.util.CommonReturnType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController()
@RequestMapping("/project")
@Api(tags = "发布的项目相关api", description = "/project")
public class ProjectPulicController extends ExceptionController {

    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private ProjectPublicService projectService;

    @GetMapping("/all")
    @ApiOperation("以简略方式获取发布的项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", required = true, value = "页数"),
            @ApiImplicitParam(name = "pageSize", required = true, value = "每页显示几个")
    })
    @ApiResponses(
            @ApiResponse(code = 200, message = "OK", response = ProjectPublicSimpleVo.class)
    )
    public CommonReturnType queryAllWithSimple(Integer pageNum, Integer pageSize)
    {
        List<ProjectPublicSimpleVo> projectPublicSimpleVos = projectService.querySimple(pageNum, pageSize);
        return CommonReturnType.ok(projectPublicSimpleVos);
    }

    @ApiOperation("获取某个项目具体信息")
    @ApiResponses(
            @ApiResponse(code = 200, message = "OK", response = ProjectPublicVo.class)
    )
    @GetMapping("/{id}")
    public CommonReturnType queryProjectPublicWithId(@PathVariable long id)
    {
        ProjectPublicVo projectPublicVo = projectService.queryById(id);
        if(projectPublicVo == null)
            return CommonReturnType.errorMsg("用户不存在");
        return CommonReturnType.ok(projectPublicVo);
    }


    @ApiOperation("查看我发布的项目")
    @ApiResponses(
            @ApiResponse(code = 200, message = "OK", response = ProjectPublicSimpleVo.class)
    )
    @GetMapping("/me")
    public CommonReturnType qureyMyProject()
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        List<ProjectPublicVo> projectPublicVos = projectService.qureyMyProject(u.getId());
        return CommonReturnType.ok(projectPublicVos);
    }

    @ApiOperation("修改项目是否可见")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "修改状态, 0代表白不显示， 1代表显示")
    )
    @PutMapping("/me/{id}")
    public CommonReturnType changeStatus(@PathVariable("id") int pid ,int status)
    {
        logger.info("id " + pid);
        logger.info("status: " + status);
        projectService.changeStatus(pid, status);
        return CommonReturnType.ok();
    }




}
