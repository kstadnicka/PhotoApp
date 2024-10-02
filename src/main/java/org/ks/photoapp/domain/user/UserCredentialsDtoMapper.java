package org.ks.photoapp.domain.user;

import org.ks.photoapp.domain.user.dto.UserCredentialsDto;

public class UserCredentialsDtoMapper {

    static UserCredentialsDto map(User user){
        return new UserCredentialsDto(
                user.getEmail(),
                user.getPassword()
        );
    }
}
