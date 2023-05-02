package Doffy.server.community.controller;

import Doffy.server.community.dto.reply.ReplyPostDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.mapper.ReplyMapper;
import Doffy.server.community.service.ReplyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/community/replies")
@Slf4j
@RequiredArgsConstructor
@Api(value = "Community Reply API")
public class ReplyController {

    private final ReplyService replyService;
    private final ReplyMapper replyMapper;

    // Create a new reply
    @PostMapping
    public ResponseEntity<ReplyResponseDto> createReply(@Valid @RequestBody ReplyPostDto replyPostDto) {
        Reply reply = replyService.createReply(replyPostDto);
        ReplyResponseDto replyResponseDto = replyMapper.toReplyResponseDto(reply);
        return new ResponseEntity<>(replyResponseDto, HttpStatus.CREATED);
    }

    // Update a reply
    @PutMapping("/{replyId}")
    public ResponseEntity<ReplyResponseDto> updateReply(@PathVariable long replyId, @Valid @RequestBody ReplyPostDto replyPostDto) {
        Reply updatedReply = replyService.updateReply(replyId, replyPostDto);
        ReplyResponseDto replyResponseDto = replyMapper.toReplyResponseDto(updatedReply);
        return new ResponseEntity<>(replyResponseDto, HttpStatus.OK);
    }

    // Delete a reply
    @DeleteMapping("/{replyId}")
    public ResponseEntity<Void> deleteReply(@PathVariable long replyId) {
        replyService.deleteReply(replyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @ApiOperation(value = "Get all replies by board ID", response = List.class)
    @GetMapping("/boards/{boardId}")
    public ResponseEntity<List<ReplyResponseDto>> getAllRepliesByBoard(
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
        List<ReplyResponseDto> replies = replyService.findRepliesByBoard(boardId);
        return ResponseEntity.ok(replies);
    }


//    @ApiOperation(value = "Get all replies by user ID", response = List.class)
//    @GetMapping("/users/{userId}")
//    public ResponseEntity<List<ReplyResponseDto>> getAllRepliesByUser(
//            @ApiParam(value = "User ID", required = true) @PathVariable long userId) {
//        List<ReplyResponseDto> replies = replyService.findRepliesByUser(userId);
//        return ResponseEntity.ok(replies);
//    }

}

