package main.config;


import main.config.serurity.JwtAuthenticationTokenFilter;
import main.config.serurity.MyLoginFailureHandler;
import main.config.serurity.MyLoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * @author 22
 */


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyLoginSuccessHandler myLoginSuccessHandler;
    @Autowired
    private MyLoginFailureHandler myLoginFailureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {




//        JWT拦截器
        JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter = new JwtAuthenticationTokenFilter();



        http.addFilterBefore(jwtAuthenticationTokenFilter,UsernamePasswordAuthenticationFilter.class);

        http.formLogin()
                //.loginPage("/loginInfo")
                .loginProcessingUrl("/login")  //form表单posturl地址
                .successHandler(myLoginSuccessHandler)
                .failureHandler(myLoginFailureHandler);
        http.authorizeRequests()
                .antMatchers("/", "/login","/loginInfo", "/register").permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/swagger-resources/**").permitAll()
                .antMatchers("/resources/images/**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/configuration/ui").permitAll()
                .antMatchers("/configuration/security").permitAll()
                .antMatchers("/images/**").permitAll()
                .anyRequest()
                .authenticated();

        http.csrf().disable();
        http.cors();
    }



    @Autowired
    private PasswordEncoder encoder;
}
