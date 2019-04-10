package main.controller;


import io.swagger.annotations.*;
import main.model.po.User;
import main.model.vo.ProjectPublicSimpleVo;
import main.model.vo.ProjectPublicVo;
import main.service.ProjectFavoriteService;
import main.service.ProjectPublicService;
import main.util.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
@Api(tags = "收藏项目相关接口", description = "/favorite")
@RestController
@RequestMapping("/favorite")
public class ProjectFavoriteController extends ExceptionController{

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    private ProjectPublicService projectService;

    @Autowired
    private ProjectFavoriteService favoriteService;

    @ApiOperation("添加我的收藏")
    @ApiImplicitParam(name = "id", value = "项目id")
    @PostMapping("/{id}")
    /**
     * id 项目id
     */
    public CommonReturnType addFavorite(@PathVariable Long id)
    {
        //TODO 是否已收藏
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        favoriteService.addFavorite(id, u.getId());
        return CommonReturnType.ok();
    }

    @ApiOperation("取消我的收藏")
    @ApiImplicitParam(name = "id", value = "项目id")
    @DeleteMapping("/{id}")
    /**
     * id 项目id
     */
    public CommonReturnType cancel(@PathVariable Long id)
    {
        favoriteService.cancelFavorite(id);
        return CommonReturnType.ok();
    }


    @ApiOperation("获取我收藏的项目")
    @ApiResponses(
            @ApiResponse(code = 200, message = "OK", response = ProjectPublicSimpleVo.class)
    )
    @GetMapping("/my")
    public CommonReturnType getMyFavrite()
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        List<Long> pids = favoriteService.getMy(u.getId());
        List<ProjectPublicVo> collect = pids.stream()
                .map(projectService::queryById)
                .collect(Collectors.toList());

        return CommonReturnType.ok(collect);

    }


}
