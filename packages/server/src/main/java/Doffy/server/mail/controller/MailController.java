package Doffy.server.mail.controller;

import Doffy.server.mail.Dto.MailDto;
import Doffy.server.mail.service.MailService;
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

    @PostMapping("/signup-auth-email")
    public void signUpCheckEmailSend(@RequestBody MailDto.AuthEmail mailDto){
        MailDto.AuthEmail createEmail = mailService.createAuthMail(mailDto);
        mailService.sendAuthEmail(createEmail);
    }

    @PostMapping("signup-check-email")
    public ResponseEntity signUpCheckEmail(@RequestBody MailDto.SignUpCheckEmail mailDto){
        mailService.verifyEmailCode(mailDto.getEmail(),mailDto.getKey());
        return new ResponseEntity(HttpStatus.OK);
    }
}
