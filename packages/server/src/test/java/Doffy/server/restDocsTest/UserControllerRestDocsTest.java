package Doffy.server.restDocsTest;

import Doffy.server.user.controller.UserController;
import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import Doffy.server.user.mapper.UserMapper;
import Doffy.server.user.service.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static Doffy.server.util.ApiDocumentUtils.getRequestPreProcessor;
import static Doffy.server.util.ApiDocumentUtils.getResponsePreProcessor;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.headers.HeaderDocumentation.headerWithName;
import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@MockBean(JpaMetamodelMappingContext.class)
@AutoConfigureRestDocs
public class UserControllerRestDocsTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private Gson gson;

    @MockBean
    UserService userService;
    @MockBean
    UserMapper userMapper;

    @Test
    public void signUpUserTest() throws Exception {
        //given
        UserDto.SignUp signUp = new UserDto.SignUp("test@test.com","비밀번호","이름","닉네임");
        String content = gson.toJson(signUp);

        //given
        given(userMapper.userSignUpToUser(Mockito.any(UserDto.SignUp.class))).willReturn(new User());

        User mockResultUser = new User();
        mockResultUser.setUserId(1L);
        given(userService.createUser(Mockito.any(User.class))).willReturn(mockResultUser);

        ResultActions actions =
                mockMvc.perform(
                        post("/api/v1/user")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                );

        //then
        actions.andExpect(status().isCreated())
                .andExpect(header().string("Location",is(startsWith("/api/v1/user"))))
                .andDo(document(
                        "signup-user",
                        getRequestPreProcessor(),
                        getResponsePreProcessor(),
                        requestFields(
                                List.of(
                                        fieldWithPath("username").type(JsonFieldType.STRING).description("이메일"),
                                        fieldWithPath("password").type(JsonFieldType.STRING).description("비밀번호"),
                                        fieldWithPath("name").type(JsonFieldType.STRING).description("이름"),
                                        fieldWithPath("nickname").type(JsonFieldType.STRING).description("닉네임")
                                )
                        ),
                        responseHeaders(
                                headerWithName(HttpHeaders.LOCATION).description("Location header. 등록된 리소스의 URI")
                        )
                ));
   }
}
