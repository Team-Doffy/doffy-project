package Doffy.server.community.controller;

import Doffy.server.community.dto.board.BoardDetailedResponseDto;
import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.dto.comment.BoardCommentPostDto;
import Doffy.server.community.dto.comment.BoardCommentResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.entity.BoardComment;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.service.BoardService;
import Doffy.server.user.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;

@WebMvcTest(BoardController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;

    @MockBean
    private BoardMapper boardMapper;

    @BeforeEach
    void setUp() {
        // Given
        User user = new User();
        user.setName("Test name");
        user.setUserId(1L);
        user.setNickname("Test NickName");

        Board board = new Board();
        board.setBoardId(1L);
        board.setUser(user);

         BoardPostDto boardPostDto = BoardPostDto.builder()
                 .title("Test Title")
                 .boardBody("Test Body")
                 .build();

         BoardResponseDto boardResponseDto = BoardResponseDto.builder()
                 .boardId(board.getBoardId())
                 .title(boardPostDto.getTitle())
                 .userId(board.getUser().getUserId())
                 .nickname(board.getUser().getNickname())
                 .replyCount(10)
                 .likeCount(10)
                 .build();

         BoardDetailedResponseDto boardDetailedResponseDto = BoardDetailedResponseDto.builder()
                 .boardId(board.getBoardId())
                 .userId(board.getUser().getUserId())
                 .nickname(board.getUser().getNickname())
                 .boardBody(boardPostDto.getBoardBody())
                 .title(boardPostDto.getTitle())
                 .build();

         when(boardMapper.toBoardDetailedResponseDto(any(Board.class))).thenReturn(boardDetailedResponseDto);
    }

    @Test
    void testCreateBoard() throws Exception {
        // Given
        BoardPostDto boardPostDto = new BoardPostDto();

        Board board = new Board();
        board.setBoardId(1L);

        BoardDetailedResponseDto boardDetailedResponseDto = new BoardDetailedResponseDto();
        boardDetailedResponseDto.setBoardId(board.getBoardId());

        when(boardService.createBoard(boardPostDto)).thenReturn(board);
        when(boardMapper.toBoardDetailedResponseDto(board)).thenReturn(boardDetailedResponseDto);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(boardPostDto);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/community/boards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardDetailedResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(boardDetailedResponseDto.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(boardDetailedResponseDto.getBoardBody()))
                .andDo(MockMvcRestDocumentation.document("create-board",
                        requestFields(
                                fieldWithPath("title").description("The title of the board"),
                                fieldWithPath("content").description("The content of the board")),
                        responseFields(
                                fieldWithPath("boardId").description("The id of the board"),
                                fieldWithPath("title").description("The title of the board"),
                                fieldWithPath("content").description("The content of the board"))))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testGetAllBoards() throws Exception {
        // Given
        int page = 0;
        int size = 20;
        List<BoardResponseDto> boards = Arrays.asList(new BoardResponseDto(), new BoardResponseDto());

        when(boardService.findAll(page, size)).thenReturn(boards);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/boards")
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].boardId").value(boards.get(0).getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value(boards.get(0).getTitle()))
                .andDo(MockMvcRestDocumentation.document("get-all-boards",
                        requestParameters(
                                parameterWithName("page").description("Page number (0-based)"),
                                parameterWithName("size").description("Number of items per page")),
                        responseFields(
                                fieldWithPath("[].boardId").description("The id of the board"),
                                fieldWithPath("[].userId").description("The id of the user"),
                                fieldWithPath("[].nickname").description("The nickname of the user"),
                                fieldWithPath("[].title").description("The title of the board"),
                                fieldWithPath("[].createdAt").description("The creation timestamp of the board"),
                                fieldWithPath("[].modifiedAt").description("The modification timestamp of the board"),
                                fieldWithPath("[].likeCount").description("The number of likes for the board"),
                                fieldWithPath("[].replyCount").description("The number of replies for the board"))))
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    void testGetBoard() throws Exception {
        // Given
        long boardId = 1L;
        Board board = new Board();
        BoardDetailedResponseDto boardDetailedResponseDto = new BoardDetailedResponseDto();

        when(boardService.findBoard(boardId)).thenReturn(board);
        when(boardMapper.toBoardDetailedResponseDto(board)).thenReturn(boardDetailedResponseDto);
                // When & Then
                mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/boards/{boardId}", boardId))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardDetailedResponseDto.getBoardId()))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(boardDetailedResponseDto.getTitle()))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(boardDetailedResponseDto.getBoardBody()))
                        .andDo(MockMvcRestDocumentation.document("get-board",
                                pathParameters(
                                        parameterWithName("boardId").description("The id of the board")),
                                responseFields(
                                        fieldWithPath("boardId").description("The id of the board"),
                                        fieldWithPath("title").description("The title of the board"),
                                        fieldWithPath("content").description("The content of the board"))))
                        .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void testUpdateBoard() throws Exception {
        // Given
        long boardId = 1L;
        BoardPostDto boardPostDto = new BoardPostDto();
        Board board = new Board();
        board.setBoardId(boardId);

        BoardDetailedResponseDto boardDetailedResponseDto = new BoardDetailedResponseDto();

        when(boardService.updateBoard(eq(boardId), any(BoardPostDto.class))).thenReturn(board);
        when(boardMapper.toBoardDetailedResponseDto(board)).thenReturn(boardDetailedResponseDto);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(boardPostDto);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.patch("/api/v1/community/boards/{boardId}", boardId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardDetailedResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(boardDetailedResponseDto.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(boardDetailedResponseDto.getBoardBody()))
                .andDo(MockMvcRestDocumentation.document("update-board",
                        pathParameters(
                                parameterWithName("boardId").description("The id of the board")),
                        requestFields(
                                fieldWithPath("title").description("The title of the board"),
                                fieldWithPath("content").description("The content of the board")),
                        responseFields(
                                fieldWithPath("boardId").description("The id of the board"),
                                fieldWithPath("title").description("The title of the board"),
                                fieldWithPath("content").description("The content of the board"))))
                .andDo(MockMvcResultHandlers.print());
    }


    @Test
    void testDeleteBoard() throws Exception {
        // Given
        long boardId = 1L;

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/community/boards/{boardId}", boardId))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcRestDocumentation.document("delete-board",
                        pathParameters(
                                parameterWithName("boardId").description("The id of the board"))))
                .andDo(MockMvcResultHandlers.print());
    }
}


