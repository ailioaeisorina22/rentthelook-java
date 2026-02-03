package ro.rentthelook.server.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//for test only
@RestController
public class MeController {

    @GetMapping("/me")
    public Map<String, Object> me(Authentication auth) {
        return Map.of(
                "userId", auth.getPrincipal(),
                "roles", auth.getAuthorities()
        );
    }
}