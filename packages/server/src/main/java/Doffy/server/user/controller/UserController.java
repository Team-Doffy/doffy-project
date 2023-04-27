package Doffy.server.user.controller;

import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import Doffy.server.user.mapper.UserMapper;
import Doffy.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Validated
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    //로그인
    @PostMapping("/signin")
    public ResponseEntity signinUser() {
        return new ResponseEntity<>("성공",HttpStatus.CREATED);
    }

    //약관 및 개인정보 수집 동의
    @PostMapping("/signup/terms")
    public ResponseEntity termsAgreeUser() {
        return new ResponseEntity<>("성공",HttpStatus.CREATED);
    }

    //회원가입 시 이메일 인증 코드 전송
    @PostMapping("/signup/email")
    public ResponseEntity signupEmail(){
        return new ResponseEntity<>("성공",HttpStatus.CREATED);
    }

    //회원가입 시 인증 확인
    @PostMapping("signup/check-code")
    public ResponseEntity signupCheckCode(){
        return new ResponseEntity<>("test",HttpStatus.OK);
    }

    //이메일 중복확인
    @GetMapping("signup/duplication-email")
    public ResponseEntity duplicationEmail(){
        return new ResponseEntity("test",HttpStatus.OK);
    }

    //닉네임 중복확인
    @PostMapping("signup/duplication-nickname")
    public ResponseEntity duplicationNickname(){
        return new ResponseEntity<>("test",HttpStatus.OK);
    }

    //최종 회원가입 버튼
    @PostMapping("signup/final")
    public ResponseEntity signupUser(@RequestBody @Valid UserDto.SignUp userSignUpDto){
        User user = userMapper.sighUpToUser(userSignUpDto);
        userService.createUser(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
