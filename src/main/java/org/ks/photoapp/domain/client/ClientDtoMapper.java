package org.ks.photoapp.domain.client;


import org.ks.photoapp.domain.client.dto.ClientDto;

public class ClientDtoMapper {
    static ClientDto map(Client client){
        return new ClientDto(
                client.getId(),
                client.getFirstName(),
                client.getLastName(),
                client.getEmail(),
                client.getPhoneNumber()
        );
    }
}
