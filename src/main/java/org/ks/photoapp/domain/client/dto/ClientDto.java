package org.ks.photoapp.domain.client.dto;

import lombok.Data;

@Data
public class ClientDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;

    public ClientDto() {
    }

    public ClientDto(Long id, String firstName, String lastName, String email, Long phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
