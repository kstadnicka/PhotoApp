package org.ks.photoapp.domain.client.dto;

import lombok.Data;
import org.ks.photoapp.domain.photoSession.PhotoSession;
import org.ks.photoapp.domain.photoSession.dto.PhotoSessionDto;

import java.util.List;

@Data
public class ClientDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;
    private List<PhotoSessionDto> photoSessions;

    public ClientDto() {
    }

    public ClientDto(Long id, Long phoneNumber, List<PhotoSessionDto> photoSessions, String email, String lastName, String firstName) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.photoSessions = photoSessions;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }

}
