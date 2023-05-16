package Doffy.server.community.controller;

import Doffy.server.community.dto.board.BoardDetailedResponseDto;
import Doffy.server.community.dto.board.BoardPostDto;
import Doffy.server.community.dto.board.BoardResponseDto;
import Doffy.server.community.entity.Board;
import Doffy.server.community.mapper.BoardCommentMapper;
import Doffy.server.community.mapper.BoardMapper;
import Doffy.server.community.service.BoardService;
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

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(BoardController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private BoardService boardService;
    @MockBean
    private BoardMapper boardMapper;
    private BoardPostDto boardPostDto;
    private BoardDetailedResponseDto boardDetailedResponseDto;

    @BeforeEach
    void setUp() {
        // Given
        boardPostDto = BoardPostDto.builder()
                .userId(1L)
                .title("Test Title")
                .boardBody("Test content")
                .build();

        boardDetailedResponseDto = BoardDetailedResponseDto.builder()
                .boardId(1L)
                .userId(boardPostDto.getUserId())
                .title(boardPostDto.getTitle())
                .boardBody(boardPostDto.getBoardBody())
                .nickname("Test Nickname")
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();

        when(boardMapper.toBoardDetailedResponseDto(any(Board.class))).thenReturn(boardDetailedResponseDto);
    }

    @Test
    void testCreateBoard() throws Exception {
        // Given
        Board board = new Board();
        board.setBoardId(boardDetailedResponseDto.getBoardId());

        when(boardService.createBoard(any(BoardPostDto.class))).thenReturn(board);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String jsonRequest = objectMapper.writeValueAsString(boardPostDto);
        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/community/boards")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardDetailedResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(boardDetailedResponseDto.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(boardDetailedResponseDto.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardBody").value(boardDetailedResponseDto.getBoardBody()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(boardDetailedResponseDto.getNickname()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").value(boardDetailedResponseDto.getCreatedAt()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.modifiedAt").value(boardDetailedResponseDto.getModifiedAt()))
                .andDo(MockMvcRestDocumentation.document("create-board",
                        PayloadDocumentation.requestFields(
                                fieldWithPath("userId").description("The id of the user"),
                                fieldWithPath("title").description("The title of the board"),
                                fieldWithPath("boardBody").description("The content of the board")
                                ),
                        responseFields(
                                fieldWithPath("boardId").description("The id of the created board"),
                                fieldWithPath("userId").description("The id of the user who created the board"),
                                fieldWithPath("title").description("The title of the created board"),
                                fieldWithPath("boardBody").description("The content of the created board"),
                                fieldWithPath("nickname").description("The nickname of the user who created the board").optional(),
                                fieldWithPath("createdAt").description("The creation time of the board").optional(),
                                fieldWithPath("modifiedAt").description("The modification time of the board").optional()
                                )));
    }
        @Test
        void testGetBoard () throws Exception {
            // Given
            Board board = new Board();
            board.setBoardId(boardDetailedResponseDto.getBoardId());

            when(boardService.findBoard(anyLong())).thenReturn(board);

            // When & Then
            mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/boards/{id}", 1L))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.boardId").value(boardDetailedResponseDto.getBoardId()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.userId").value(boardDetailedResponseDto.getUserId()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(boardDetailedResponseDto.getTitle()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.boardBody").value(boardDetailedResponseDto.getBoardBody()))
                    .andExpect(MockMvcResultMatchers.jsonPath("$.nickname").value(boardDetailedResponseDto.getNickname()))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.createdAt").value(boardDetailedResponseDto.getCreatedAt()))
//                    .andExpect(MockMvcResultMatchers.jsonPath("$.modifiedAt").value(boardDetailedResponseDto.getModifiedAt()))
                    .andDo(MockMvcRestDocumentation.document("get-board",
                            pathParameters(
                                    parameterWithName("id").description("The id of the board to retrieve")
                                    ),
                            responseFields(
                                    fieldWithPath("boardId").description("The id of the created board"),
                                    fieldWithPath("userId").description("The id of the user who created the board"),
                                    fieldWithPath("title").description("The title of the created board"),
                                    fieldWithPath("boardBody").description("The content of the created board"),
                                    fieldWithPath("nickname").description("The nickname of the user who created the board").optional(),
                                    fieldWithPath("createdAt").description("The creation time of the board").optional(),
                                    fieldWithPath("modifiedAt").description("The modification time of the board").optional()
                            )));
        }

    @Test
    void testGetAllBoards() throws Exception {
        // Given
        int page = 0;
        int size = 20;
        List<BoardResponseDto> boards = new ArrayList<>();

        User user = User.builder()
                .userId(1L)
                .nickname("Test Nickname")
                .username("Test Name")
                .build();

        BoardResponseDto boardResponseDto = BoardResponseDto.builder()
                .boardId(boardDetailedResponseDto.getBoardId())
                .userId(boardPostDto.getUserId())
                .nickname(user.getNickname())
                .likeCount(10)
                .replyCount(20)
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .title(boardPostDto.getTitle())
                .build();

        boards.add(boardResponseDto);

        when(boardService.findAll(page, size)).thenReturn(boards);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/community/boards")
                        .param("page", String.valueOf(page))
                        .param("size", String.valueOf(size)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].boardId").value(boardResponseDto.getBoardId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].userId").value(boardResponseDto.getUserId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value(boardResponseDto.getTitle()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].nickname").value(boardResponseDto.getNickname()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].createdAt").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].modifiedAt").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].likeCount").value(boardResponseDto.getLikeCount()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].replyCount").value(boardResponseDto.getReplyCount()))
                .andDo(MockMvcRestDocumentation.document("get-all-boards",
                        requestParameters(
                                parameterWithName("page").description("The page number (0-based)"),
                                parameterWithName("size").description("The number of items per page")
                        ),
                        responseFields(
                                fieldWithPath("[].boardId").description("The id of the board"),
                                fieldWithPath("[].userId").description("The id of the user who created the board"),
                                fieldWithPath("[].title").description("The title of the board"),
                                fieldWithPath("[].nickname").description("The nickname of the user who created the board"),
                                fieldWithPath("[].createdAt").description("The creation time of the board"),
                                fieldWithPath("[].modifiedAt").description("The modification time of the board"),
                                fieldWithPath("[].likeCount").description("The number of likes for the board"),
                                fieldWithPath("[].replyCount").description("The number of replies for the board")
                        )));
    }

    @Test
    void testUpdateBoard() throws Exception {
        // Given
        Board updatedBoard = new Board();
        updatedBoard.setBoardId(boardDetailedResponseDto.getBoardId());
        updatedBoard.setTitle("Updated Title");
        updatedBoard.setBoardBody("Updated content");

        BoardPostDto updateDto = BoardPostDto.builder()
                .userId(1L)
                .title(updatedBoard.getTitle())
                .boardBody(updatedBoard.getBoardBody())
                .build();

        when(boardService.updateBoard(anyLong(), any(BoardPostDto.class))).thenReturn(updatedBoard);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(updateDto);

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.put("/api/v1/community/boards/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Test Title"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.boardBody").value("Test content"))
                .andDo(
                        MockMvcRestDocumentation.document("update-board",
                        pathParameters(
                                parameterWithName("id").description("The id of the board to update")
                        ),
                        PayloadDocumentation.requestFields(
                                fieldWithPath("userId").description("The id of the user"),
                                fieldWithPath("title").description("The updated title of the board"),
                                fieldWithPath("boardBody").description("The updated content of the board")
                        ),
                        responseFields(
                                fieldWithPath("boardId").description("The id of the updated board"),
                                fieldWithPath("userId").description("The id of the user who updated the board"),
                                fieldWithPath("nickname").description("The nickname of the user who updated the board"),
                                fieldWithPath("title").description("The title of the updated board"),
                                fieldWithPath("boardBody").description("The content of the updated board"),
                                fieldWithPath("createdAt").description("The creation timestamp of the updated board"),
                                fieldWithPath("modifiedAt").description("The modification timestamp of the updated board")
                        )
    ));
    }

    @Test
    void testDeleteBoard() throws Exception {
        // Given
        doNothing().when(boardService).deleteBoard(anyLong());

        // When & Then
        mockMvc.perform(RestDocumentationRequestBuilders.delete("/api/v1/community/boards/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isNoContent())
                .andDo(MockMvcRestDocumentation.document("delete-board",
                        pathParameters(
                                parameterWithName("id").description("The id of the board to delete")
                        )));
    }


}
