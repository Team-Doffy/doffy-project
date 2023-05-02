package Doffy.server.community.service;


import Doffy.server.community.dto.reply.ReplyPostDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.mapper.ReplyMapper;
import Doffy.server.community.repository.ReplyRepository;
import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  ReplyService {
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final ReplyMapper replyMapper;
    public Reply createReply(ReplyPostDto replyPostDto) {
        User user = userRepository.findById(replyPostDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Board board = new Board();
        board.setBoardId(replyPostDto.getBoardId());
        Reply reply = replyMapper.toReply(replyPostDto, board);
        reply.setUser(user);
        return replyRepository.save(reply);
    }

    public Reply updateReply(long replyId, ReplyPostDto replyPostDto) {
        Reply reply = findVerifiedReply(replyId);
        reply.setReplyBody(replyPostDto.getReplyBody());
        reply.setModifiedAt(LocalDateTime.now());
        return replyRepository.save(reply);
    }

    public void deleteReply(long replyId) {
        Reply reply = findVerifiedReply(replyId);
        replyRepository.delete(reply);
    }

    public List<ReplyResponseDto> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return replyRepository.findAll(pageable)
                .stream()
                .map(reply -> replyMapper.toReplyResponseDto(reply))
                .collect(Collectors.toList());
    }

    public Reply findReply(long replyId) {
        return findVerifiedReply(replyId);
    }

    public Reply findVerifiedReply(long replyId) {
        return replyRepository.findById(replyId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPLY_NOT_FOUND));
    }
}