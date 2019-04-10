package main.controller;


import io.swagger.annotations.*;
import main.model.po.User;
import main.model.vo.IdeaVo;
import main.service.IdeaService;
import main.util.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "金点子增删改查接口", description = "/idea")
@RestController
@RequestMapping("/idea")
public class IdeaController extends ExceptionController {



    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IdeaService ideaService;


    @ApiOperation(value = "查询当前用户的所有金点子", notes = "金点子增删改查接口")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功 + data数据", response = IdeaVo.class),
            @ApiResponse(code = 500, message = "其他为失败", response = IdeaVo.class)

    })
    @GetMapping("/all")
    public CommonReturnType getAll()
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        List<IdeaVo> ideas = ideaService.selectAll(u.getId());
        return CommonReturnType.ok(ideas);
    }

    @ApiOperation(value = "查询具体用户的所有金点子")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功 + data数据", response = IdeaVo.class),
            @ApiResponse(code = 500, message = "其他为失败", response = IdeaVo.class)

    })
    @GetMapping("/{id}")
    public CommonReturnType getDetail(@PathVariable Long id)
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        IdeaVo ideaVo = ideaService.selkectById(id);
        return CommonReturnType.ok(ideaVo);
    }


    @ApiOperation(value = "当前用户添加金点子")
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 500, message = "其他为失败", response = IdeaVo.class)

    })
    @PostMapping("/add")
    public CommonReturnType addOne(@RequestBody IdeaVo ideaVo)
    {

        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        ideaService.add(ideaVo, u.getId());
        return CommonReturnType.ok();
    }
}
