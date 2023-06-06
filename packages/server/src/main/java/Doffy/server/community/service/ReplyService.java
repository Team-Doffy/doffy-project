package Doffy.server.community.service;


import Doffy.server.community.dto.reply.ReplyPostDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.dto.reply.ReplyUpdateDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.mapper.ReplyMapper;
import Doffy.server.community.repository.ReplyRepository;
import Doffy.server.global.exception.BusinessLogicException;
import Doffy.server.global.exception.ExceptionCode;
import Doffy.server.user.entity.User;
import Doffy.server.user.repository.UserRepository;
import Doffy.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  ReplyService {
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final ReplyMapper replyMapper;
    private final BoardService boardService;
    private final UserService userService;

    public Reply createReply(ReplyPostDto replyPostDto) {
        User user = userRepository.findById(replyPostDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Board board = boardService.findVerifiedBoard(replyPostDto.getBoardId());
        Reply reply = replyMapper.toReply(replyPostDto, board, user);
        return replyRepository.save(reply);
    }

    public Reply updateReply(long replyId, ReplyUpdateDto updateDto) {
        Reply reply = findVerifiedReply(replyId);
        reply.setReplyBody(updateDto.getReplyBody());
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

    public List<ReplyResponseDto> findRepliesByBoard(long boardId) {
        Board getBoard = boardService.findVerifiedBoard(boardId);
        List<Reply> replies = replyRepository.findByBoard(getBoard);
        List<ReplyResponseDto> responseDtos = replies.stream()
                .map(reply -> replyMapper.toReplyResponseDto(reply))
                .collect(Collectors.toList());
        return responseDtos;
    }

//    public List<ReplyResponseDto> findRepliesByUser(String username) {
//        User getUser = userService.verifyExistsUsername(username);
//        List<Reply> replies = replyRepository.findByUser(getUser);
//        List<ReplyResponseDto> responseDtos = replies.stream()
//                .map(reply -> replyMapper.toReplyResponseDto(reply))
//                .collect(Collectors.toList());
//        return responseDtos;
//    }


    public Reply findReply(long replyId) {
        return findVerifiedReply(replyId);
    }

    public Reply findVerifiedReply(long replyId) {
        return replyRepository.findById(replyId)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.REPLY_NOT_FOUND));
    }
}