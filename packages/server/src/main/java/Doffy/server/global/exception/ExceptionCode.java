package Doffy.server.global.exception;


import lombok.Getter;

public enum ExceptionCode {

    //이미 존재하는 아이디(이메일)
    USERNAME_EXISTS(400, "Username already exists"),

    //이미 존재하는 닉네임
    NICKNAME_EXISTS(400, "Nick already exists");

    @Getter
    private final int status;
    @Getter
    private final String message;

    ExceptionCode(int status, String message){
        this.status = status;
        this.message = message;
    }
}
