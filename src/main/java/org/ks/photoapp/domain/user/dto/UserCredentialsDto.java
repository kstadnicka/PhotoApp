package org.ks.photoapp.domain.user.dto;

import lombok.Data;

@Data
public class UserCredentialsDto {
    private String email;
    private String password;


    public UserCredentialsDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
