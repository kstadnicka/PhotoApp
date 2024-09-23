package org.ks.photoapp.domain.user;

import org.ks.photoapp.domain.user.dto.UserDto;

public class UserDtoMapper {

    static UserDto map(User user){
        return new UserDto(
                user.getEmail(),
                user.getPassword()
        );
    }
}
