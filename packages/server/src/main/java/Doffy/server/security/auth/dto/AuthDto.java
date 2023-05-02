package Doffy.server.security.auth.dto;

import lombok.Getter;

@Getter
public class AuthDto {
    @Getter
    public static class SignInDto{
        private String username;
        private String password;
    }
}
