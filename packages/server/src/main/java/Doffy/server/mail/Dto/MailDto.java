package Doffy.server.mail.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

public class MailDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AuthEmail{
        private String email;
        private String title;
        private String message;
        private String createKey;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SignUpCheckEmail{
        private String email;
        private String key;
    }
}
