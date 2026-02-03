package ro.rentthelook.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.rentthelook.server.dto.AuthResponse;
import ro.rentthelook.server.dto.LoginRequest;
import ro.rentthelook.server.dto.RegisterRequest;
import ro.rentthelook.server.entity.User;
import ro.rentthelook.server.service.UserService;

import java.util.Map;

@RestController
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        userService.register(request);
        return ResponseEntity.status(201)
                .body(Map.of("message", "User created successfully!"));
    }

    // POST /api/login
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        System.out.println("LOGIN HIT: Email=" + req);
        return ResponseEntity.ok(userService.login(req));
    }
}
