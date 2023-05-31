
package Doffy.server.mail.service;

import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.mail.Dto.MailDto;
import Doffy.server.redis.util.RedisUtil;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import Doffy.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MailService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder passwordEncoder;
    private final RedisUtil redisUtil;
    private final UserService userService;

    private static final String FROM_ADDRESS = "teamdoffy@gmail.com";

    public void sendEmail(MailDto.AuthEmail mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getEmail());
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getMessage());
        javaMailSender.send(message);
    }

    @Transactional
    public MailDto.AuthEmail createAuthMail(MailDto.AuthEmail mailDto) {
        String createdKey = createKey();
        MailDto.AuthEmail createdMail = new MailDto.AuthEmail();
        createdMail.setEmail(mailDto.getEmail());
        createdMail.setTitle("Doffy 회원가입 이메일 인증번호 발송 메일 입니다.");
        createdMail.setMessage("Doffy에 오신것을 환영 합니다! 이메일 인증번호는 " + createdKey + " 입니다.");
        if(redisUtil.existData(mailDto.getEmail())){
            redisUtil.deleteData(mailDto.getEmail());
        }
        redisUtil.setDataExpire(mailDto.getEmail(), createdKey, 300);
        return createdMail;
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

    @Transactional
    public MailDto.AuthEmail createFindPasswordMail(MailDto.AuthEmail mailDto){
        User verifyUser = userService.findVerifyUser(mailDto.getEmail());
        String createdKey = createKey();
        User findPasswordUser = userRepository.findByUsername(mailDto.getEmail());
        String encodedNewPassword = passwordEncoder.encode(createdKey);
        findPasswordUser.setPassword(encodedNewPassword);
        userRepository.save(findPasswordUser);
        MailDto.AuthEmail createdMail = new MailDto.AuthEmail();
        createdMail.setEmail(mailDto.getEmail());
        createdMail.setTitle("Doffy 임시 비밀번호 발송 메일입니다.");
        createdMail.setMessage("Doffy 임시 비밀번호는 " + createdKey + " 입니다.");
        return createdMail;
    }
}
