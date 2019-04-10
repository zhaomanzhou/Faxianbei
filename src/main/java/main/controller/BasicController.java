package main.controller;


import main.util.CommonReturnType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理通用的请求
 */

@Controller
public class BasicController {


    //@RequestMapping("/loginInfo")
    public CommonReturnType pleaseLogin()
    {
        return CommonReturnType.errorUnlogin();
    }
}
