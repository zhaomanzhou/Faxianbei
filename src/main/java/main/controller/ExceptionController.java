package main.controller;

import io.jsonwebtoken.ExpiredJwtException;
import main.util.CommonReturnType;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionController {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest req, HttpServletResponse res, Exception e)
    {
            if(e instanceof AuthenticationServiceException || e instanceof ExpiredJwtException)
            {
                return CommonReturnType.errorWithCode(503, "登录已过期");
            }else if (e instanceof NullPointerException)
            {
                return CommonReturnType.errorWithCode(501, "查询的信息不存在 或token有问题");
            }else if(e instanceof IllegalArgumentException)
            {
                return CommonReturnType.errorWithCode(502, "未登录");
            }


            return CommonReturnType.errorException("服务器内部错误");

    }


}
