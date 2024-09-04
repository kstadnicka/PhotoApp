package org.ks.photoapp.domain.client;


import org.ks.photoapp.domain.client.dto.ClientDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

   private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDto> getAllClients() {
       List<Client> clients = (List<Client>)clientRepository.findAll();
       return clients.stream()
               .map(ClientDtoMapper::map)
               .toList();
    }

    public Optional<ClientDto> findClientById(long id){
        return clientRepository.findById(id)
                .map(ClientDtoMapper::map);
    }

    public Optional<ClientDto> findClientByLastName(String lastName){
        return clientRepository.findByLastName(lastName)
                .map(ClientDtoMapper::map);
    }

    @Transactional
    public void createNewClient(ClientDto clientDto){
        Client client = new Client();
        client.setLastName(clientDto.getLastName());
        client.setFirstName(clientDto.getFirstName());
        client.setEmail(clientDto.getEmail());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);
    }

    public void updateClientDetails(ClientDto clientDto, long id) {
    Client clientToUpdate = clientRepository.findById(id)
            .orElseGet(Client::new);
    clientToUpdate.setLastName(clientDto.getLastName());
    clientToUpdate.setFirstName(clientDto.getFirstName());
    clientToUpdate.setEmail(clientDto.getEmail());
    clientToUpdate.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(clientToUpdate);
    }


    public void deleteClient(Long id){
        clientRepository.deleteClientById(id);
    }
}
