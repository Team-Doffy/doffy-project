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

import java.util.List;

@RestController
@RequestMapping("/api/v1/community/replies")
@Slf4j
@RequiredArgsConstructor
@Api(value = "Community Reply API")
public class ReplyController {

    private final ReplyService replyService;
    private final ReplyMapper replyMapper;

    @ApiOperation(value = "Create a new reply", response = ReplyResponseDto.class)
    @PostMapping("/{boardId}")
    public ResponseEntity<ReplyResponseDto> createReply(
            @ApiParam(value = "Reply information", required = true) @RequestBody ReplyPostDto replyPostDto,
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
        Reply reply = replyService.createReply(replyPostDto, boardId);
        ReplyResponseDto response = replyMapper.toReplyResponseDto(reply, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(value = "Update a reply by ID", response = ReplyResponseDto.class)
    @PutMapping("/{replyId}")
    public ResponseEntity<ReplyResponseDto> updateReply(
            @ApiParam(value = "Reply ID", required = true) @PathVariable long replyId,
            @ApiParam(value = "Reply information", required = true) @RequestBody ReplyPostDto replyPostDto) {
        Reply reply = replyService.updateReply(replyId, replyPostDto);
        ReplyResponseDto response = replyMapper.toReplyResponseDto(reply, null);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Delete a reply by ID")
    @DeleteMapping("/{replyId}")
    public ResponseEntity<Void> deleteReply(
            @ApiParam(value = "Reply ID", required = true) @PathVariable long replyId) {
        replyService.deleteReply(replyId);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Get a reply by ID", response = ReplyResponseDto.class)
    @GetMapping("/{replyId}")
    public ResponseEntity<ReplyResponseDto> getReply(
            @ApiParam(value = "Reply ID", required = true) @PathVariable long replyId) {
        Reply reply = replyService.findReply(replyId);
        ReplyResponseDto response = replyMapper.toReplyResponseDto(reply, null);
        return ResponseEntity.ok(response);
    }

    @ApiOperation(value = "Get all replies by board ID", response = List.class)
    @GetMapping("/boards/{boardId}")
    public ResponseEntity<List<ReplyResponseDto>> getAllRepliesByBoard(
            @ApiParam(value = "Board ID", required = true) @PathVariable long boardId) {
        List<ReplyResponseDto> replies = replyService.findRepliesByBoard(boardId);
        return ResponseEntity.ok(replies);
    }


    @ApiOperation(value = "Get all replies by user ID", response = List.class)
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<ReplyResponseDto>> getAllRepliesByUser(
            @ApiParam(value = "User ID", required = true) @PathVariable long userId) {
        List<ReplyResponseDto> replies = replyService.findRepliesByUser(userId);
        return ResponseEntity.ok(replies);
    }

}

