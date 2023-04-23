package Doffy.server.community.controller;

import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/community")
@Slf4j
public class BoardController {
    private BoardService boardService;
    private BoardMapper boardMapper;
}
