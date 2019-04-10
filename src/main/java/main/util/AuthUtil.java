package main.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {


    public static String secret;


    @Value("${token.secret}")
    public void setSecret(String secret) {
        AuthUtil.secret = secret;
    }

    public static String getSecret()
    {
        return secret;
    }
}
