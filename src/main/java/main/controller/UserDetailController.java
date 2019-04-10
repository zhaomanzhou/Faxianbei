package main.controller;


import io.swagger.annotations.*;
import main.model.po.StudentDetail;
import main.model.po.User;
import main.model.vo.StudentDetailVo;
import main.service.StudentDetailService;
import main.util.CommonReturnType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Api(tags = "个人中心相关接口", description = "/user/detail")
@RestController
@RequestMapping("/user/detail")
public class UserDetailController extends ExceptionController {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private HttpServletRequest request;


    @Autowired
    private StudentDetailService detailService;


    @ApiOperation("查询某个用户详细信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "查询成功", response = StudentDetailVo.class),
    })

    @GetMapping("/{id}")
    public CommonReturnType getDetail(@PathVariable Long id)
    {
        StudentDetailVo studentDetailVo = detailService.selectById(id);
        return CommonReturnType.ok(studentDetailVo);
    }



    @ApiOperation("查询当前登录用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", required = true, value = "授权获得的token", paramType = "header")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "用户名或密码为空"),
            @ApiResponse(code = 510, message = "用户已存在"),
            @ApiResponse(code = 200, message = "查询成功", response = StudentDetailVo.class)
    })
    @GetMapping("/my")
    public CommonReturnType getMyDetail()
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        StudentDetailVo studentDetailVo = detailService.selectById(u.getId());
        return CommonReturnType.ok(studentDetailVo);
    }


    @ApiOperation("修改指定用户详细信息, 提交时不需要id参数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", required = true, value = "授权获得的token", paramType = "header")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "用户名或密码为空"),
            @ApiResponse(code = 510, message = "用户已存在"),
            @ApiResponse(code = 200, message = "查询成功", response = StudentDetailVo.class)
    })
    @PutMapping("/my")
    public CommonReturnType updateDetail(StudentDetailVo sdv)
    {
        String token = request.getHeader("token");
        User u = (User)redisTemplate.opsForValue().get(token);
        StudentDetail sd = new StudentDetail();
        BeanUtils.copyProperties(sdv, sd);
        sd.setUserId(u.getId());
        detailService.updateUser(sd);
        return CommonReturnType.ok();
    }

}
