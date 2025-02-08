package ru.vsu.cs.masalkin.internet_shop.api.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMainController {

    @GetMapping("/AdminMain")
    public String AdminMain() {
        return "AdminMain";
    }
}
