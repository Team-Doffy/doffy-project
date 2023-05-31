package Doffy.server.mail.controller;

import Doffy.server.mail.Dto.MailDto;
import Doffy.server.mail.service.MailService;
import Doffy.server.redis.util.RedisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;
    private final RedisUtil redisUtil;

    @PostMapping("/findpw-send-email")
    public void sendNewPasswordEmail(@RequestBody MailDto.AuthEmail mailDto){
        MailDto.AuthEmail createEmail = mailService.createFindPasswordMail(mailDto);
        mailService.sendEmail(createEmail);
    }

    @PostMapping("/signup-auth-email")
    public void signUpCheckEmailSend(@RequestBody MailDto.AuthEmail mailDto) {
        MailDto.AuthEmail createEmail = mailService.createAuthMail(mailDto);
        mailService.sendEmail(createEmail);
    }

    @PostMapping("signup-check-email")
    public ResponseEntity signUpCheckEmail(@RequestBody MailDto.Key key) {
        mailService.verifyEmailCode(key.getKey(), key.getValue());
        redisUtil.deleteData(key.getKey());
        return new ResponseEntity(HttpStatus.OK);
    }
}
