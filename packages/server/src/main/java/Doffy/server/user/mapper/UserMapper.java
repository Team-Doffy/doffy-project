package Doffy.server.user.mapper;

import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User sighUpToUser(UserDto.SignUp requestBody);
}
