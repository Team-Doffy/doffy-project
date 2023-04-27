package Doffy.server.user.service;

import Doffy.server.user.entity.User;
import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    //회원가입
    public User createUser(User user){
        verifyExistsUsername(user.getUsername());  //이메일 중복확인 재 검증
        verifyExistsNickname(user.getNickname());  //닉네임 중복확인 재 검증
        String rawPassword = user.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword); // rawPassword 인코딩
        user.setPassword(encPassword); // 인코딩된 패스워드 user에 저장
        user.setTerms(true); //약관 동의 True로 변경
        User savedUser = userRepository.save(user);  // 회원정보 db 저장
        return savedUser;
    }

    //이메일 중복확인
    public void verifyExistsUsername(String username){
        User existUsername = userRepository.findByUsername(username);
        if(existUsername != null){
            throw new BusinessLogicException(ExceptionCode.USERNAME_EXISTS);
        }
    }

    //닉네임 중복확인
    public void verifyExistsNickname(String nickname){
        User existNickname = userRepository.findByNickname(nickname);
        if(existNickname != null){
            throw new BusinessLogicException(ExceptionCode.NICKNAME_EXISTS);
        }
    }
}
