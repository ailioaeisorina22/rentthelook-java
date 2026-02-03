package ro.rentthelook.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminTestController {

    @GetMapping("/admin/ping")
    public String ping() {
        return "OK - ADMIN";
    }
}