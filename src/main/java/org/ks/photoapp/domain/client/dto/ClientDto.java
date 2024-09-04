package org.ks.photoapp.domain.client.dto;

import lombok.Data;

@Data
public class ClientDto {
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;

    public ClientDto() {
    }

    public ClientDto(Long phoneNumber, String email, String lastName, String firstName) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
