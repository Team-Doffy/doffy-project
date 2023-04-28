package Doffy.server.user.mapper;

import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    User sighUpToUser(UserDto.SignUp requestBody);
}
