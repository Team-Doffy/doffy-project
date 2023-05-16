package Doffy.server.user.controller;

import Doffy.server.global.utils.UriCreator;
import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import Doffy.server.user.mapper.UserMapper;
import Doffy.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Validated
public class UserController {
    private final static String USER_DEFAULT_URL = "/api/v1/user";
    private final UserService userService;
    private final UserMapper userMapper;

    //회원 생성
    @PostMapping
    public ResponseEntity signupUser(@RequestBody @Valid UserDto.SignUp userSignUpDto){
        User user = userMapper.SignUpToUser(userSignUpDto);
        User createdUser = userService.createUser(user);
        URI location = UriCreator.createUri(USER_DEFAULT_URL, createdUser.getUserId());
        return ResponseEntity.created(location).build();
    }

    //회원 조회
    @GetMapping
    public ResponseEntity getUser(@AuthenticationPrincipal String username){
        User findUser = userService.findUser(username);
        UserDto.GetUserResponse response = userMapper.userToGetUserResponse(findUser);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    //회원수정
    @PutMapping
    public ResponseEntity updateUser(@AuthenticationPrincipal String username,
                                     @RequestBody @Valid UserDto.Patch userPatchDto){
        userPatchDto.setUsername(username);
        User user = userMapper.patchToUser(userPatchDto);
        return new ResponseEntity("test",HttpStatus.OK);
    }


    //회원삭제
    @DeleteMapping
    public ResponseEntity deleteUser(@AuthenticationPrincipal String username){
        userService.deleteUser(username);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

//    //약관 및 개인정보 수집 동의
//    @PostMapping("/signup-terms")
//    public ResponseEntity termsAgreeUser() {
//        return new ResponseEntity<>("성공",HttpStatus.CREATED);
//    }

    //회원가입 시 이메일 인증 코드 전송
    @PostMapping("/signup-email")
    public ResponseEntity signupEmail(){
        return new ResponseEntity<>("성공",HttpStatus.CREATED);
    }

    //회원가입 시 인증 확인
    @PostMapping("/signup-code")
    public ResponseEntity signupCheckCode(){
        return new ResponseEntity<>("test",HttpStatus.OK);
    }

    //이메일 중복확인
    @GetMapping("duplication-email")
    public ResponseEntity duplicationCheckEmail(@RequestBody @Valid UserDto.DuplicationCheckUsername checkUsernameDto){
        User user = userMapper.duplicationCheckUsernameToUser(checkUsernameDto);
        boolean checkedUsername = userService.duplicationCheckUsername(user.getUsername());
        UserDto.DuplicationCheckUsernameResponse response = userMapper.userToDuplicationCheckUsernameResponse(user);
        response.setUsernameCheck(checkedUsername);

        return new ResponseEntity(response,HttpStatus.OK);
    }

    //닉네임 중복확인
    @GetMapping("duplication-nickname")
    public ResponseEntity duplicationCheckNickname(@RequestBody @Valid UserDto.DuplicationCheckNickname checkNicknameDto){
        User user = userMapper.duplicationCheckNicknameToUser(checkNicknameDto);
        boolean checkedNickname = userService.duplicationCheckNickname(user.getNickname());
        UserDto.DuplicationCheckNicknameResponse response = userMapper.userToDuplicationCheckNicknameResponse(user);
        response.setNicknameCheck(checkedNickname);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    //비밀번호 확인
    @GetMapping("check-password")
    public ResponseEntity checkPassword(@AuthenticationPrincipal String username,
                                        @RequestBody UserDto.CheckPassword checkPasswordDto){
        User originUser = userService.findUser(username);
        User checkPasswordUser = userMapper.checkPasswordToUser(checkPasswordDto);
        Boolean checkedPassword = userService.checkPassword(originUser.getUsername(), checkPasswordUser.getPassword());
        UserDto.CheckPasswordResponse response = userMapper.userToCheckPasswordResponse(checkPasswordUser);
        response.setCheckPassword(checkedPassword);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
