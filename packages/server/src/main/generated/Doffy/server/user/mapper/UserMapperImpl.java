package Doffy.server.user.mapper;

import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-15T22:47:40+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userSignUpToUser(UserDto.SignUp requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( requestBody.getUsername() );
        user.password( requestBody.getPassword() );
        user.name( requestBody.getName() );
        user.nickname( requestBody.getNickname() );

        return user.build();
    }
}
