package Doffy.server.user.mapper;

import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User SignUpToUser(UserDto.SignUp requestBody);
    User patchNicknameToUser(UserDto.PatchNickname requestBody);
    User duplicationCheckUsernameToUser(UserDto.DuplicationCheckUsername requestBody);
    User duplicationCheckNicknameToUser(UserDto.DuplicationCheckNickname requestBody);
    User checkPasswordToUser(UserDto.CheckPassword requestBody);
    UserDto.GetUserResponse userToGetUserResponse(User user);
    UserDto.DuplicationCheckUsernameResponse userToDuplicationCheckUsernameResponse (User user);
    UserDto.DuplicationCheckNicknameResponse userToDuplicationCheckNicknameResponse (User user);
    UserDto.CheckPasswordResponse userToCheckPasswordResponse (User user);
}
