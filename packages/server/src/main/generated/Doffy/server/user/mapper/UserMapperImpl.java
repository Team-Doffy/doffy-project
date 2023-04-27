package Doffy.server.user.mapper;

import Doffy.server.user.dto.UserDto;
import Doffy.server.user.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-27T22:18:56+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User sighUpToUser(UserDto.SignUp requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( requestBody.getUsername() );
        user.password( requestBody.getPassword() );
        user.nickname( requestBody.getNickname() );
        user.terms( requestBody.isTerms() );

        return user.build();
    }
}
