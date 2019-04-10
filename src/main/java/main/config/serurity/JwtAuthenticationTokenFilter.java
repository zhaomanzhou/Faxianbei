package main.config.serurity;

import main.model.po.User;
import main.util.Jwtutil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());




    @Autowired
    private RedisTemplate<Object, Object> redisTemplate ;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {


        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        redisTemplate = (RedisTemplate<Object, Object>) webApplicationContext.getBean("redisTemplate");

        //获取JWT
        String token = request.getHeader("token");
        logger.info("authHeader:" + token);

        //token合法生成一个authentication对象
        if (token != null)
        {

            if(Jwtutil.isValidate(token))
            {
                logger.info("token合法");
                Object o = redisTemplate.opsForValue().get(token);
                if(o != null)
                {
                    logger.info("redis中存在用户");
                    User u = (User)o;
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(u.getName(), u.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }else
                {
                    logger.info("redis中用户已过期");
                }
            }else
            {
                logger.info("token不合法");
            }


        }
        filterChain.doFilter(request, response);
    }



}
