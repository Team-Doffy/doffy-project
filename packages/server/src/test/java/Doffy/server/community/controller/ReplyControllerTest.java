package Doffy.server.community.controller;

import Doffy.server.community.dto.reply.ReplyPostDto;
import Doffy.server.community.dto.reply.ReplyResponseDto;
import Doffy.server.community.entity.Reply;
import Doffy.server.community.mapper.ReplyMapper;
import Doffy.server.community.service.ReplyService;
import Doffy.server.user.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static Doffy.server.util.ApiDocumentUtils.getRequestPreProcessor;
import static Doffy.server.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(ReplyController.class)
@AutoConfigureRestDocs
class ReplyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReplyService replyService;

    @MockBean
    private ReplyMapper replyMapper;

    private ReplyPostDto replyPostDto;
    private ReplyResponseDto replyResponseDto;

    @BeforeEach
    void setUp() {
        // Given
        replyPostDto = ReplyPostDto.builder()
                .userId(1L)
                .boardId(1L)
                .replyBody("Test reply content")
                .build();

        replyResponseDto = ReplyResponseDto.builder()
                .replyId(1L)
                .boardId(replyPostDto.getBoardId())
                .userId(replyPostDto.getUserId())
                .replyBody(replyPostDto.getReplyBody())
                .isAccepted(true)
                .nickname("Test Nickname")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        when(replyMapper.toReplyResponseDto(any(Reply.class))).thenReturn(replyResponseDto);
    }

    @Test
    void testCreateReply() throws Exception {
        // Given
        Reply reply = new Reply();
        reply.setReplyId(replyResponseDto.getReplyId());

        when(replyService.createReply(any(ReplyPostDto.class))).thenReturn(reply);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonRequest = objectMapper.writeValueAsString(replyPostDto);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/community/replies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.replyId").value(replyResponseDto.getReplyId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(replyResponseDto.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(replyResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.replyBody").value(replyResponseDto.getReplyBody()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(replyResponseDto.getNickname()))
                .andDo(MockMvcRestDocumentation.document("create-reply",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        PayloadDocumentation.requestFields(
                                fieldWithPath("boardId").description("Board ID"),
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyBody").description("Reply Body") ,
                                fieldWithPath("createdAt").description("The creation time of the reply").ignored(),
                                fieldWithPath("modifiedAt").description("The modification time of the reply").ignored()
                        ),
                        PayloadDocumentation.responseFields(
                                fieldWithPath("replyId").description("Reply ID"),
                                fieldWithPath("boardId").description("Board ID"),
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyBody").description("Reply Body"),
                                fieldWithPath("nickname").description("Nickname"),
                                fieldWithPath("isAccepted").description("Whether the reply is accepted or not"),
                                fieldWithPath("accepted").description("Whether the reply is accepted or not (deprecated)"),
                                fieldWithPath("createdAt").description("Created At"),
                                fieldWithPath("modifiedAt").description("Modified At")
                        )
                ));
    }

    @Test
    void testGetReply() throws Exception {
        // Given
        long replyId = 1;
        Reply reply = new Reply();
        reply.setReplyId(replyId);

        when(replyService.findReply(anyLong())).thenReturn(reply);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/replies/{replyId}", replyId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.replyId").value(replyId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(replyResponseDto.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(replyResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.replyBody").value(replyResponseDto.getReplyBody()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(replyResponseDto.getNickname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.modifiedAt").isNotEmpty())
                .andDo(MockMvcRestDocumentation.document("get-reply",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("replyId").description("The ID of the reply to retrieve")
                        ),
                        responseFields(
                                fieldWithPath("replyId").description("The ID of the reply"),
                                fieldWithPath("userId").description("The ID of the user who created the reply"),
                                fieldWithPath("boardId").description("Board ID"),
                                fieldWithPath("nickname").description("The nickname of the user who created the reply"),
                                fieldWithPath("replyBody").description("The body of the reply"),
                                fieldWithPath("isAccepted").description("Whether the reply is accepted or not"),
                                fieldWithPath("accepted").description("Whether the reply is accepted or not (deprecated)"),
                                fieldWithPath("createdAt").description("The creation time of the reply"),
                                fieldWithPath("modifiedAt").description("The modification time of the reply")
                        )
                ));
    }

    @Test
    void testUpdateReply() throws Exception {
        // Given
        long replyId = 1;
        ReplyPostDto updateDto = ReplyPostDto.builder()
                .replyBody("Updated reply content")
                .build();

        Reply updatedReply = new Reply();
        updatedReply.setReplyId(replyId);
        updatedReply.setReplyBody(updateDto.getReplyBody());

        when(replyService.updateReply(anyLong(), any(ReplyPostDto.class))).thenReturn(updatedReply);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonRequest = objectMapper.writeValueAsString(updateDto);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/v1/community/replies/{replyId}", replyId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.replyId").value(replyId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(replyResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(replyResponseDto.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.replyBody").value("Test reply content"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(replyResponseDto.getNickname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.modifiedAt").isNotEmpty())
                .andDo(MockMvcRestDocumentation.document("update-reply",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("replyId").description("The ID of the reply to update")
                        ),
                        PayloadDocumentation.requestFields(
                                fieldWithPath("boardId").description("Board ID"),
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("replyBody").description("Reply Body"),
                                fieldWithPath("createdAt").description("The creation time of the reply").ignored(),
                                fieldWithPath("modifiedAt").description("The modification time of the reply").ignored()
                        ),
                        responseFields(
                                fieldWithPath("replyId").description("The ID of the updated reply"),
                                fieldWithPath("userId").description("User ID"),
                                fieldWithPath("boardId").description("Board ID"),
                                fieldWithPath("replyBody").description("Reply Body"),
                                fieldWithPath("nickname").description("Nickname"),
                                fieldWithPath("isAccepted").description("Whether the reply is accepted or not"),
                                fieldWithPath("accepted").description("Whether the reply is accepted or not (deprecated)"),
                                fieldWithPath("createdAt").description("Created At"),
                                fieldWithPath("modifiedAt").description("Modified At")
                        )
                ));
    }

    @Test
    void testGetReplies() throws Exception {
        // Given
        int page = 0;
        int size = 10;
        List<ReplyResponseDto> replies = new ArrayList<>();
        User user = User.builder()
                .userId(1L)
                .nickname("Test Nickname")
                .username("Test Name")
                .build();

        ReplyResponseDto replyResponseDto = ReplyResponseDto.builder()
                .replyId(1L)
                .userId(user.getUserId())
                .nickname(user.getNickname())
                .replyBody("Test reply")
                .isAccepted(true)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        replies.add(replyResponseDto);

        when(replyService.findAll(page, size)).thenReturn(replies);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/replies")
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].replyId").value(replyResponseDto.getReplyId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(replyResponseDto.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].boardId").value(replyResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nickname").value(replyResponseDto.getNickname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].replyBody").value(replyResponseDto.getReplyBody()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].isAccepted").value(replyResponseDto.isAccepted()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].createdAt").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].modifiedAt").isNotEmpty())
                .andDo(MockMvcRestDocumentation.document("get-replies",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestParameters(
                                parameterWithName("page").description("The page number (0-based)"),
                                parameterWithName("size").description("The number of items per page")
                        ),
                        responseFields(
                                fieldWithPath("[].replyId").description("The ID of the reply"),
                                fieldWithPath("[].userId").description("The ID of the user who created the reply"),
                                fieldWithPath("[].boardId").description("Board ID"),
                                fieldWithPath("[].nickname").description("The nickname of the user who created the reply"),
                                fieldWithPath("[].replyBody").description("The body of the reply"),
                                fieldWithPath("[].isAccepted").description("Whether the reply is accepted or not"),
                                fieldWithPath("[].accepted").description("Whether the reply is accepted or not (deprecated)"),
                                fieldWithPath("[].createdAt").description("The creation time of the reply"),
                                fieldWithPath("[].modifiedAt").description("The modification time of the reply")
                        )
                ));
    }



    @Test
    void testDeleteReply() throws Exception {
        // Given
        doNothing().when(replyService).deleteReply(anyLong());

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/community/replies/{replyId}", 1L)
                        .param("userId", "1"))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcRestDocumentation.document("delete-reply",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        pathParameters(
                                parameterWithName("replyId").description("Reply ID")
                        ),
                        requestParameters(
                                parameterWithName("userId").description("User ID")
                        )
                ));
    }
}

