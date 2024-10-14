package ru.geekbrains.spring_lesson7_security_dz_sulagaevdv;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Для проверки необходимо перейти на страницу http://localhost:8080/login
 * данные для авторизации пользователя: user / user
 * данные для авторизации администратора: admin / admin
 */
@Controller
@RequestMapping()
public class UserController {
    @GetMapping("/public-data")
    @ResponseBody
    public String getPublicData() {
        return "Публичная страница (для всех авторизованных пользователей)";
    }

    @GetMapping("/private-data")
    @ResponseBody
    public String getPrivateData() {
        return "Закрытая страница (только для администраторов)";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/welcome-page")
    public String welcomePage(Model model) {
        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
        return "welcome-page";
    }

    @GetMapping("/error")
    public String accessDenied() {
        return "error";
    }
}
