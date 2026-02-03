package ro.rentthelook.server.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ro.rentthelook.server.dto.AuthResponse;
import ro.rentthelook.server.dto.LoginRequest;
import ro.rentthelook.server.dto.RegisterRequest;
import ro.rentthelook.server.entity.User;
import ro.rentthelook.server.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest request) {
        userRepository.findByEmail(request.getEmail()).ifPresent(
                u -> {
                    throw new IllegalArgumentException("This email is already in use!");
                }
        );

        User user = new User();
        user.setLastName(request.getUserLastName());
        user.setFirstName(request.getUserFirstName());
        user.setAge(request.getUserAge());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setGender(request.getUserGender());
        user.setPhone(request.getPhone());
        user.setRole("CLIENT");

        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest req) {
        String email = req.getEmail();
        String password = req.getPassword();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("The user doesn't exist!"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Incorrect password!");
        }

        String token = jwtService.generateToken(user);

        return new AuthResponse(
                "Succes Auth",
                token,
                user.getUserId(),
                user.getRole()
        );
    }

    public User getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("The user was not found!"));
    }
}
