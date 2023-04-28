package Doffy.server.community.service;

import Doffy.server.community.dto.reply.ReplyPostDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.mapper.ReplyMapper;
import Doffy.server.community.repository.ReplyRepository;
import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;

    public Reply createReply(ReplyPostDto replyPostDto, long boardId) {
        Board board = new Board();
        board.setBoardId(boardId);
        Reply reply = replyMapper.toReply(replyPostDto, board);
        return replyRepository.save(reply);
    }

    public Reply updateReply(long replyId, ReplyPostDto replyPostDto) {
        Reply reply = findVerifiedReply(replyId);
        reply.setReplyBody(replyPostDto.getReplyBody());
        return replyRepository.save(reply);
    }

    public void deleteReply(long replyId) {
        Reply reply = findVerifiedReply(replyId);
        replyRepository.delete(reply);
    }

    public List<ReplyResponseDto> findRepliesByBoard(long boardId) {
        List<Reply> replies = replyRepository.findByBoardId(boardId);
        List<ReplyResponseDto> responseDtos = replies.stream()
                .map(reply -> replyMapper.toReplyResponseDto(reply, null))
                .collect(Collectors.toList());
        return responseDtos;
    }

    public List<ReplyResponseDto> findRepliesByUser(long userId) {
        List<Reply> replies = replyRepository.findByUserId(userId);
        List<ReplyResponseDto> responseDtos = replies.stream()
                .map(reply -> replyMapper.toReplyResponseDto(reply, null))
                .collect(Collectors.toList());
        return responseDtos;
    }

    public Reply findReply(long replyId) {
        return findVerifiedReply(replyId);
    }

    public Reply findVerifiedReply(long replyId) {
        return replyRepository.findById(replyId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPLY_NOT_FOUND));
    }
}

