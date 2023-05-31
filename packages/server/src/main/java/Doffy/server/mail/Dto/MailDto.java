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
        private String createCode;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FindEmail{
        private String email;
        private String title;
        private String message;
        private String createCode;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Key{
        private String key;
        private String value;
    }
}
