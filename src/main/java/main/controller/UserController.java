package main.controller;


import io.swagger.annotations.*;
import main.service.UserService;
import main.util.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "注册登录相关接口", description= "/")
public class UserController extends ExceptionController{

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("注册账号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", required = true, value = "用户名"),
            @ApiImplicitParam(name = "password", required = true, value = "密码")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "用户名或密码为空"),
            @ApiResponse(code = 510, message = "用户已存在"),
            @ApiResponse(code = 200, message = "注册成功")
    })
    public CommonReturnType register(String username, String password)
    {
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password))
            return CommonReturnType.errorWithCode(500, "用户名或密码为空");
        String p = userService.getPasswordByUsername(username);
        if(p != null)
            return CommonReturnType.errorWithCode(510, "用户已存在");
        userService.insertUser(username, password);
        return CommonReturnType.ok("注册成功");
    }



    @ApiOperation("未授权访问需要登录地址时,会被重定向这里")
    @ApiResponses({
            @ApiResponse(code = 501, message = "未登录"),
    })
    @RequestMapping("/loginInfo")
    public CommonReturnType loginInfo()
    {
        return CommonReturnType.errorWithCode(501, "未登录");
    }

    @ApiOperation("登录, 接口是login, 框架配置好了,这里只是展示文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", required = true, value = "用户名"),
            @ApiImplicitParam(name = "password", required = true, value = "密码")
    })
    @ApiResponses({
            @ApiResponse(code = 500, message = "用户名或密码错误"),
            @ApiResponse(code = 510, message = "用户名或密码为空"),
            @ApiResponse(code = 200, message = "登录成功token")
    })
    @PostMapping("/login1")
    public void login1()
    {

    }


}
