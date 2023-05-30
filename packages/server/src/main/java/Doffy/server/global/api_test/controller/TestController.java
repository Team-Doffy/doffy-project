package Doffy.server.global.api_test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public ResponseEntity test(){
        return new ResponseEntity("테스트 성공", HttpStatus.OK);
    }
}
