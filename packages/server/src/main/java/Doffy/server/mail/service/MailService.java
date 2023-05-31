package Doffy.server.mail.service;

import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.mail.Dto.MailDto;
import Doffy.server.redis.util.RedisUtil;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;

    private static final String FROM_ADDRESS = "teamdoffy@gmail.com";

    public void sendAuthEmail(MailDto.AuthEmail mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getEmail());
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());
        javaMailSender.send(message);
    }

    public MailDto.AuthEmail createAuthMail(MailDto.AuthEmail mailDto) {
        String createdKey = createKey();
        MailDto.AuthEmail createMail = new MailDto.AuthEmail();
        createMail.setEmail(mailDto.getEmail());
        createMail.setTitle("Doffy 회원가입 이메일 인증번호 발송 메일 입니다."+'\n');
        createMail.setMessage("Doffy에 오신것을 환영 합니다! 이메일 인증번호는 " + createdKey + " 입니다.");
        createMail.setCreateKey(createMail.getCreateKey());
        if(redisUtil.existData(mailDto.getEmail())){
            redisUtil.deleteData(mailDto.getEmail());
        }
        redisUtil.setDataExpire(mailDto.getEmail(), createdKey, 300);
        return createMail;
    }

    public void verifyEmailCode(String email, String code){
        String foundedCode = redisUtil.getData(email);
        if(foundedCode == null) throw new BusinessLogicException(ExceptionCode.CODE_MISMATCH);
        if(!foundedCode.equals(code)) throw new BusinessLogicException(ExceptionCode.CODE_MISMATCH);
    }

    public String createKey() {
        char[] charSet = new char[]{
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
        };
        String createdKey = "";
        int idx = 0;
        for (int i = 0; i < 6; i++) {
            idx = (int) (Math.random() * charSet.length);
            createdKey += charSet[idx];
        }
        return createdKey;
    }
}
