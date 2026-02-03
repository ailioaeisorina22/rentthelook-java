package ro.rentthelook.server.dto;

public class AuthResponse {
    private String message;
    private String token;
    private Integer userId;
    private String role;

    public AuthResponse(String message, String token, Integer userId, String role) {
        this.message = message;
        this.token = token;
        this.userId = userId;
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}