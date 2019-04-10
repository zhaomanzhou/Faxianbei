package main.config.serurity;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import main.model.po.User;
import main.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@Component("myLoginSuccessHandler")
public class MyLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler { //自定义的


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Autowired
    private UserService userService;

    @Value("${token.expiration}")
    private Integer expireTime;

    @Value("${token.secret}")
    private String secret;

    @Value("${token.redis.expiration}")
    private Integer redisExpiration;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        logger.info("登录成功！");


        logger.info("secret: " + secret);
//        登录成功后设置JWT
        Date exp = new Date(System.currentTimeMillis() + 1000L * 60 * expireTime);
        logger.info("过期时间"  + exp);
        String token = Jwts.builder()

                .setSubject(authentication.getName())  //用户
                //过期时间
                .setExpiration(exp)
                //加密方式
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();

        //        要做的工作就是将Authentication以json的形式返回给前端。 需要工具类ObjectMapper，Spring已自动注入。
        //设置返回类型
        httpServletResponse.setContentType("application/json;charset=UTF-8");
//        //将token信息写入
        //httpServletResponse.getWriter().write(objectMapper.writeValueAsString(CommonReturnType.ok(Token)));

        User u = userService.getUserByUserName(authentication.getName());
        HashMap<String, String > map = new HashMap<>();
        map.put("token", token);
        map.put("user_id", u.getId()+ "");
        redisTemplate.opsForValue().set(token, u, redisExpiration, TimeUnit.MINUTES);
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(map));

    }
}