//package Doffy.server.community.controller;
//
//import Doffy.server.community.dto.comment.BoardCommentPostDto;
//import Doffy.server.community.dto.comment.BoardCommentResponseDto;
//import Doffy.server.community.entity.Board;
//import Doffy.server.community.entity.BoardComment;
//import Doffy.server.community.mapper.BoardCommentMapper;
//import Doffy.server.community.service.BoardCommentService;
//import Doffy.server.community.service.BoardService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
//import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
//import org.springframework.restdocs.payload.PayloadDocumentation;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.List;
//
//import static Doffy.server.util.ApiDocumentUtils.getRequestPreProcessor;
//import static Doffy.server.util.ApiDocumentUtils.getResponsePreProcessor;
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//
//@WebMvcTest(BoardCommentController.class)
//@AutoConfigureRestDocs
//class BoardCommentControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private BoardCommentService commentService;
//    @MockBean
//    private BoardService boardService;
//    @MockBean
//    private BoardCommentMapper boardCommentMapper;
//
//    private BoardCommentPostDto boardCommentPostDto;
//    private BoardCommentResponseDto boardCommentResponseDto;
//
//    @BeforeEach
//    void setUp() {
//        // Given
//        boardCommentPostDto = BoardCommentPostDto.builder()
//                .boardId(1L)
//                .userId(1L)
//                .boardCommentBody("Test content")
//                .createdAt(LocalDateTime.now())
//                .modifiedAt(LocalDateTime.now())
//                .build();
//
//        boardCommentResponseDto = BoardCommentResponseDto.builder()
//                .boardCommentId(1L)
//                .boardId(boardCommentPostDto.getBoardId())
//                .userId(boardCommentPostDto.getUserId())
//                .nickname("Test User")
//                .boardCommentBody(boardCommentPostDto.getBoardCommentBody())
//                .createdAt(boardCommentPostDto.getCreatedAt())
//                .modifiedAt(boardCommentPostDto.getModifiedAt())
//                .build();
//
//        when(boardCommentMapper.toCommentResponseDto(any(BoardComment.class))).thenReturn(boardCommentResponseDto);
//    }
//
//    @Test
//    void testCreateComment() throws Exception {
//        // Given
//        Board board = new Board();
//        board.setBoardId(boardCommentPostDto.getBoardId());
//
//        BoardComment boardComment = new BoardComment();
//        boardComment.setBoard(board);
//        boardComment.setBoardCommentId(1L);
//
//        when(boardService.findBoard(eq(boardCommentPostDto.getBoardId()))).thenReturn(board);
//        when(commentService.createComment(any(BoardCommentPostDto.class), any(Board.class))).thenReturn(boardComment);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        String jsonRequest = objectMapper.writeValueAsString(boardCommentPostDto);
//
//
//        // When & Then
//        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/community/board-comments?boardId=" + boardCommentPostDto.getBoardId())
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonRequest))
//                .andExpect(MockMvcResultMatchers.status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardCommentId").value(boardCommentResponseDto.getBoardCommentId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardCommentResponseDto.getBoardId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(boardCommentResponseDto.getUserId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(boardCommentResponseDto.getNickname()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardCommentBody").value(boardCommentResponseDto.getBoardCommentBody()))
////                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").value(matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}")))
////                .andExpect(MockMvcResultMatchers.jsonPath("$.modifiedAt").value(matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}")))
//                .andDo(MockMvcRestDocumentation.document("create-comment",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestParameters(
//                                parameterWithName("boardId").description("The id of the board where the comment is posted")),
//                        PayloadDocumentation.requestFields(
//                                fieldWithPath("boardId").description("The id of the board"),
//                                fieldWithPath("userId").description("The id of the user"),
//                                fieldWithPath("boardCommentBody").description("The body of the comment"),
//                                fieldWithPath("createdAt").description("The creation timestamp of the comment"),
//                                fieldWithPath("modifiedAt").description("The last modified timestamp of the comment")),
//                        PayloadDocumentation.responseFields(
//                                fieldWithPath("boardCommentId").description("The id of the comment"),
//                                fieldWithPath("boardId").description("The id of the board"),
//                                fieldWithPath("userId").description("The id of the user"),
//                                fieldWithPath("nickname").description("The nickname of the user"),
//                                fieldWithPath("boardCommentBody").description("The body of the comment"),
//                                fieldWithPath("createdAt").description("The creation timestamp of the comment"),
//                                fieldWithPath("modifiedAt").description("The last modified timestamp of the comment"))));
//    }
//
//    @Test
//    void testGetComment() throws Exception {
//        // Given
//        long commentId = 1L;
//        BoardComment boardComment = new BoardComment();
//        boardComment.setBoardCommentId(commentId);
//
//        when(commentService.findComment(commentId)).thenReturn(boardComment);
//        when(boardCommentMapper.toCommentResponseDto(boardComment)).thenReturn(boardCommentResponseDto);
//
//        // When & Then
//        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/board-comments/{commentId}", commentId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardCommentId").value(boardCommentResponseDto.getBoardCommentId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardCommentResponseDto.getBoardId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(boardCommentResponseDto.getUserId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(boardCommentResponseDto.getNickname()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardCommentBody").value(boardCommentResponseDto.getBoardCommentBody()))
//                .andDo(MockMvcRestDocumentation.document("get-comment",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("commentId").description("The id of the comment")),
//                        PayloadDocumentation.responseFields(
//                                fieldWithPath("boardCommentId").description("The id of the comment"),
//                                fieldWithPath("boardId").description("The id of the board"),
//                                fieldWithPath("userId").description("The id of the user"),
//                                fieldWithPath("nickname").description("The nickname of the user"),
//                                fieldWithPath("boardCommentBody").description("The body of the comment"),
//                                fieldWithPath("createdAt").description("The creation timestamp of the comment"),
//                                fieldWithPath("modifiedAt").description("The last modified timestamp of the comment"))))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    void testUpdateComment() throws Exception {
//        // Given
//        long commentId = 1L;
//        BoardCommentPostDto updatedPostDto = boardCommentPostDto;
//        updatedPostDto.setBoardCommentBody("Updated content");
//
//        BoardComment boardComment = new BoardComment();
//        boardComment.setBoardCommentId(commentId);
//
//        when(commentService.updateComment(eq(commentId), any(BoardCommentPostDto.class))).thenReturn(boardComment);
//        when(boardCommentMapper.toCommentResponseDto(boardComment)).thenReturn(boardCommentResponseDto);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//        String jsonRequest = objectMapper.writeValueAsString(updatedPostDto);
//
//        // When & Then
//        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/v1/community/board-comments/{commentId}", commentId)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(jsonRequest))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardCommentId").value(boardCommentResponseDto.getBoardCommentId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardCommentResponseDto.getBoardId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(boardCommentResponseDto.getUserId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(boardCommentResponseDto.getNickname()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.boardCommentBody").value(boardCommentResponseDto.getBoardCommentBody()))
//                .andDo(MockMvcRestDocumentation.document("update-comment",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("commentId").description("The id of the comment")),
//                        PayloadDocumentation.requestFields(
//                                fieldWithPath("boardId").description("The id of the board"),
//                                fieldWithPath("userId").description("The id of the user"),
//                                fieldWithPath("boardCommentBody").description("The body of the comment"),
//                                fieldWithPath("createdAt").description("The creation timestamp of the comment"),
//                                fieldWithPath("modifiedAt").description("The last modified timestamp of the comment")),
//                        PayloadDocumentation.responseFields(
//                                fieldWithPath("boardCommentId").description("The id of the comment"),
//                                fieldWithPath("boardId").description("The id of the board"),
//                                fieldWithPath("userId").description("The id of the user"),
//                                fieldWithPath("nickname").description("The nickname of the user"),
//                                fieldWithPath("boardCommentBody").description("The body of the comment"),
//                                fieldWithPath("createdAt").description("The creation timestamp of the comment"),
//                                fieldWithPath("modifiedAt").description("The last modified timestamp of the comment"))))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    void testDeleteComment() throws Exception {
//        // Given
//        long commentId = 1L;
//
//        // When & Then
//        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/community/board-comments/{commentId}", commentId))
//                .andExpect(MockMvcResultMatchers.status().isNoContent())
//                .andDo(MockMvcRestDocumentation.document("delete-comment",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("commentId").description("The id of the comment"))))
//                .andDo(MockMvcResultHandlers.print());
//    }
//
//    @Test
//    void testGetCommentsByBoard() throws Exception {
//        // Given
//        long boardId = 1L;
//        List<BoardCommentResponseDto> comments = Collections.singletonList(boardCommentResponseDto);
//
//        when(commentService.findBoardComments(boardId)).thenReturn(comments);
//
//        // When & Then
//        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/board-comments/board/{boardId}", boardId))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].boardCommentId").value(boardCommentResponseDto.getBoardCommentId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].boardId").value(boardCommentResponseDto.getBoardId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(boardCommentResponseDto.getUserId()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nickname").value(boardCommentResponseDto.getNickname()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].boardCommentBody").value(boardCommentResponseDto.getBoardCommentBody()))
//                .andDo(MockMvcRestDocumentation.document("get-comments-by-board",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(
//                                parameterWithName("boardId").description("The id of the board")),
//                        PayloadDocumentation.responseFields(
//                                fieldWithPath("[].boardCommentId").description("The id of the comment"),
//                                fieldWithPath("[].boardId").description("The id of the board"),
//                                fieldWithPath("[].userId").description("The id of the user"),
//                                fieldWithPath("[].nickname").description("The nickname of the user"),
//                                fieldWithPath("[].boardCommentBody").description("The body of the comment"),
//                                fieldWithPath("[].createdAt").description("The creation timestamp of the comment"),
//                                fieldWithPath("[].modifiedAt").description("The last modified timestamp of the comment"))))
//                .andDo(MockMvcResultHandlers.print());
//    }
//}

