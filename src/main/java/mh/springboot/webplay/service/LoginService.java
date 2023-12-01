package mh.springboot.webplay.service;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.logging.Logger;

@Service
@RequestScope
public class LoginService {

    private final Logger logger = Logger.getLogger(LoginService.class.getName());
    private String username;
    private String password;

    public boolean authorize() {
        logger.info("printing hash of the LoginService instance that currently do the check: " + this);
        logger.info("username: " + username + " with password: " + password + " is trying to authorize");
        return "natalia".equals(username) && "npassword".equals(password);
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
