package ru.geekbrains.spring_lesson7_security_dz_sulagaevdv;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping()
public class UserController {
    @GetMapping("/public-data")
    @ResponseBody
    public String getPublicData() {
        return "Доступ к общедоступным данным.";
    }

    @GetMapping("/private-data")
    @ResponseBody
    public String getPrivateData() {
        return "Доступ к приватным данным только для ADMIN.";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String accessDenied() {
        return "error";
    }
}
