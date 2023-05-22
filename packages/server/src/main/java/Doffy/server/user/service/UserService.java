package Doffy.server.user.service;

import Doffy.server.security.auth.utils.DoffyAuthorityUtils;
import Doffy.server.user.entity.User;
import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final DoffyAuthorityUtils doffyAuthorityUtils;


    //회원가입
    public User createUser(User user){
        verifyExistsUsername(user.getUsername());  //이메일 중복확인 재 검증
        verifyExistsNickname(user.getNickname());  //닉네임 중복확인 재 검증
        String rawPassword = user.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword); // rawPassword 인코딩
        user.setPassword(encPassword); // 인코딩된 패스워드 user에 저장
        user.setTerms(true); //약관 동의 True로 변경
        List<String> roles = doffyAuthorityUtils.createRoles(user.getUsername());
        user.setRoles(roles);
        return userRepository.save(user);
    }

    //회원조회
    public User findUser(String username){
        return findVerifyUser(username);
    }

    //존재하는 회원인지 검증
    public User findVerifyUser(String username){
        User verifyUser = userRepository.findByUsername(username);
        if(verifyUser == null) throw new BusinessLogicException(ExceptionCode.USER_NOT_FOUND);
        return verifyUser;
    }

    //이메일 중복확인
    public void verifyExistsUsername(String username) {
        User existUsername = userRepository.findByUsername(username);
        if (existUsername != null) {
            throw new BusinessLogicException(ExceptionCode.USERNAME_EXISTS);
        }
    }

    //닉네임 중복확인
    public void verifyExistsNickname(String nickname) {
        User existNickname = userRepository.findByNickname(nickname);
        if (existNickname != null) {
            throw new BusinessLogicException(ExceptionCode.NICKNAME_EXISTS);
        }
    }

    //회원 삭제
    public void deleteUser(String username){
        User findUser = findVerifyUser(username);
        userRepository.delete(findUser);
    }

    //비밀번호 검증
    public void checkPassword(String username, String password){
        User findUser = findUser(username);
        String originPassword = findUser.getPassword();
        if(!passwordEncoder.matches(password,originPassword)) {
            throw new BusinessLogicException(ExceptionCode.PASSWORD_MISMATCH);
        }
    }

    //닉네임 수정
    public User updateNickname(User user){
        User findUser = findVerifyUser(user.getUsername());
        if(!user.getNickname().equals(findUser.getNickname())) {
            verifyExistsNickname(user.getNickname());
        }
        String rawPassword = user.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword);
        Optional.ofNullable(user.getNickname())
                .ifPresent(nickname -> findUser.setNickname(nickname));
        Optional.ofNullable(encPassword)
                .ifPresent(password -> findUser.setPassword(password));
        return userRepository.save(findUser);
    }
}
