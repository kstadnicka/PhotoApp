package org.ks.photoapp.domain.client;


import org.ks.photoapp.domain.client.dto.ClientDto;

public class ClientDtoMapper {
    static ClientDto map(Client client){
        return new ClientDto(
                client.getPhoneNumber(),
                client.getEmail(),
                client.getLastName(),
                client.getFirstName()
        );
    }
}
