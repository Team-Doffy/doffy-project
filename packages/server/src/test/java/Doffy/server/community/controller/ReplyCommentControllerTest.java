package Doffy.server.community.controller;

import Doffy.server.community.dto.comment.ReplyCommentPostDto;
import Doffy.server.community.dto.comment.ReplyCommentResponseDto;
import Doffy.server.community.entity.ReplyComment;
import Doffy.server.community.service.ReplyCommentService;
import Doffy.server.community.mapper.ReplyCommentMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static Doffy.server.util.ApiDocumentUtils.getRequestPreProcessor;
import static Doffy.server.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReplyCommentController.class)
@AutoConfigureRestDocs
class ReplyCommentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReplyCommentService replyCommentService;
    @MockBean
    private ReplyCommentMapper replyCommentMapper;
    private ReplyCommentPostDto replyCommentPostDto;
    private ReplyCommentResponseDto replyCommentResponseDto;

    @BeforeEach
    void setUp() {
        // Given
        replyCommentPostDto = ReplyCommentPostDto.builder()
                .userId(1L)
                .replyCommentBody("Test reply comment content")
                .build();

        replyCommentResponseDto = ReplyCommentResponseDto.builder()
                .replyCommentId(1L)
                .userId(replyCommentPostDto.getUserId())
                .replyCommentBody(replyCommentPostDto.getReplyCommentBody())
                .nickname("Test Nickname")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        when(replyCommentMapper.toCommentResponseDto(any(ReplyComment.class))).thenReturn(replyCommentResponseDto);
    }

    @Test
    void testCreateReplyComment() throws Exception {
        // Given
        ReplyComment replyComment = new ReplyComment();
        replyComment.setReplyCommentId(replyCommentResponseDto.getReplyCommentId());

        when(replyCommentService.createComment(any(ReplyCommentPostDto.class))).thenReturn(replyComment);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonRequest = objectMapper.writeValueAsString(replyCommentPostDto);
        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/community/replycomments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.replyCommentId").value(replyCommentResponseDto.getReplyCommentId()))
                .andExpect(jsonPath("$.userId").value(replyCommentResponseDto.getUserId()))
                .andExpect(jsonPath("$.replyCommentBody").value(replyCommentResponseDto.getReplyCommentBody()))
                .andExpect(jsonPath("$.nickname").value(replyCommentResponseDto.getNickname()))
                .andExpect(jsonPath("$.createdAt").isNotEmpty())
                .andExpect(jsonPath("$.modifiedAt").isNotEmpty())
                .andDo(print())
                .andDo(document("create-replyComment",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyCommentBody").description("Reply comment body"),
                                fieldWithPath("replyId").description("The reply ID associated with the comment")
                        ),
                        responseFields(
                                fieldWithPath("replyCommentId").description("Reply comment ID"),
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyId").description("The reply ID associated with the comment"),
                                fieldWithPath("replyCommentBody").description("Reply comment body"),
                                fieldWithPath("nickname").description("Nickname"),
                                fieldWithPath("createdAt").description("Time of creation"),
                                fieldWithPath("replyId").description("The reply ID associated with the comment"),
                                fieldWithPath("modifiedAt").description("Time of last modification")
                        )));
    }

    @Test
    void testUpdateReplyComment() throws Exception {
        // Given
        ReplyComment updatedReplyComment = new ReplyComment();
        updatedReplyComment.setReplyCommentId(replyCommentResponseDto.getReplyCommentId());
        updatedReplyComment.setReplyCommentBody("Updated reply comment body");

        ReplyCommentPostDto updateDto = ReplyCommentPostDto.builder()
                .userId(1L)
                .replyCommentBody(updatedReplyComment.getReplyCommentBody())
                .build();

        when(replyCommentService.updateComment(anyLong(), any(ReplyCommentPostDto.class))).thenReturn(updatedReplyComment);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(updateDto);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/v1/community/replycomments/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.replyCommentBody").value("Test reply comment content"))
                .andDo(print())
                .andDo(document("update-replyComment",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("id").description("Reply comment ID")
                        ),
                        requestFields(
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyCommentBody").description("Reply comment body"),
                                fieldWithPath("replyId").description("The reply ID associated with the comment")
                        ),
                        responseFields(
                                fieldWithPath("replyCommentId").description("Reply comment ID"),
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyId").description("The reply ID associated with the comment"),
                                fieldWithPath("replyCommentBody").description("Reply comment body"),
                                fieldWithPath("nickname").description("Nickname"),
                                fieldWithPath("createdAt").description("Time of creation"),
                                fieldWithPath("modifiedAt").description("Time of last modification")
                        )));
    }

    @Test
    void testGetReplyComment() throws Exception {
        // Given
        ReplyComment replyComment = new ReplyComment();
        replyComment.setReplyCommentId(replyCommentResponseDto.getReplyCommentId());

        when(replyCommentService.findComment(anyLong())).thenReturn(replyComment);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/replycomments/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.replyCommentId").value(replyCommentResponseDto.getReplyCommentId()))
                .andExpect(jsonPath("$.userId").value(replyCommentResponseDto.getUserId()))
                .andExpect(jsonPath("$.replyCommentBody").value(replyCommentResponseDto.getReplyCommentBody()))
                .andExpect(jsonPath("$.nickname").value(replyCommentResponseDto.getNickname()))
                .andExpect(jsonPath("$.createdAt").isNotEmpty())
                .andExpect(jsonPath("$.modifiedAt").isNotEmpty())
                .andDo(print())
                .andDo(document("get-replyComment",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("id").description("Reply comment ID")
                        ),
                        responseFields(
                                fieldWithPath("replyCommentId").description("Reply comment ID"),
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyId").description("The reply ID associated with the comment"),
                                fieldWithPath("replyCommentBody").description("Reply comment body"),
                                fieldWithPath("nickname").description("Nickname"),
                                fieldWithPath("createdAt").description("Time of creation"),
                                fieldWithPath("modifiedAt").description("Time of last modification")
                                )));
    }

    @Test
    void testGetAllReplyComments() throws Exception {
        // Given
        List<ReplyCommentResponseDto> replyCommentResponseDtos = Arrays.asList(new ReplyCommentResponseDto(), new ReplyCommentResponseDto());

        when(replyCommentService.findReplyComments(1L)).thenReturn(replyCommentResponseDtos);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/replycomments/reply/{replyId}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andDo(print())
                .andDo(document("get-all-replyComments",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("replyId").description("The ID of the reply")
                        ),
                        responseFields(
                                fieldWithPath("[].replyCommentId").description("Array of reply comment IDs"),
                                fieldWithPath("[].replyId").description("Array of reply IDs"),
                                fieldWithPath("[].userId").description("Array of user IDs"),
                                fieldWithPath("[].replyCommentBody").description("Array of reply comment bodies"),
                                fieldWithPath("[].nickname").description("Array of nicknames"),
                                fieldWithPath("[].createdAt").description("Array of creation times"),
                                fieldWithPath("[].modifiedAt").description("Array of last modification times")
                        )
                ));
    }


        @Test
    void testDeleteReplyComment() throws Exception {
        // Given
        doNothing().when(replyCommentService).deleteComment(anyLong());
        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/community/replycomments/{id}", 1L))
                .andExpect(status().isNoContent())
                .andDo(print())
                .andDo(document("delete-replyComment",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("id").description("Reply comment ID")
                        )));
    }
}
