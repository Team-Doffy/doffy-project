package Doffy.server.global.api_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestOAuthController {
        @GetMapping("/oauth2")
        public String home(){
            return "hello-oauth2";
    }
}
