package main.config.serurity;

import main.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class MyUserDetailService implements UserDetailsService {


    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    private PasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        log.info("userName: "+ s);

        String passed = userService.getPasswordByUsername(s);
        if(passed == null)
            throw new UsernameNotFoundException("用户名不存在");
        User admin = new User(s, passed, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return admin;
    }
}
