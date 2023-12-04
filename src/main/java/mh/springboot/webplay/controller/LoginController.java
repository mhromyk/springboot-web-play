package mh.springboot.webplay.controller;

import mh.springboot.webplay.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        loginService.setUsername(username);
        loginService.setPassword(password);
        boolean loggedIn = loginService.authorize();

        if (loggedIn) {
            return "redirect:/main";
        } else {
            model.addAttribute("message", "authentication failed");
        }

        return "Login.html";
    }

    @GetMapping("/")
    public String getLoginPage() {
        return "Login.html";
    }

}
