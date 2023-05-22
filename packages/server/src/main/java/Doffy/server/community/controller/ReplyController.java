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
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;
    private final ReplyMapper replyMapper;

    @GetMapping("/{replyId}")
    public ResponseEntity<ReplyResponseDto> getReply(
            @ApiParam(value = "Reply ID", required = true) @PathVariable long replyId) {
        Reply reply = replyService.findReply(replyId);
        ReplyResponseDto response = replyMapper.toReplyResponseDto(reply);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ReplyResponseDto>> getReplies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<ReplyResponseDto> replies = replyService.findAll(page, size);
        return new ResponseEntity<>(replies, HttpStatus.OK);
    }

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
}

