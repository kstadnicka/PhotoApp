package org.ks.photoapp.domain.photoSession;


import org.ks.photoapp.domain.client.Client;
import org.ks.photoapp.domain.client.ClientDtoMapper;
import org.ks.photoapp.domain.client.ClientRepository;
import org.ks.photoapp.domain.payment.Payment;
import org.ks.photoapp.domain.payment.PaymentRepository;
import org.ks.photoapp.domain.photoSession.dto.PhotoSessionDto;
import org.ks.photoapp.domain.photos.Photos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhotoSessionService {
    private final ClientRepository clientRepository;
    PhotoSessionRepository photoSessionRepository;

    public PhotoSessionService(PhotoSessionRepository photoSessionRepository, ClientRepository clientRepository) {
        this.photoSessionRepository = photoSessionRepository;
        this.clientRepository = clientRepository;
    }

    public List<PhotoSessionDto> getAllPhotoSession() {
        List<PhotoSession> photoSessions = photoSessionRepository.findAll();
        return photoSessions.stream()
                .filter(photoSession -> !photoSession.isContractFinished)
                .map(PhotoSessionDtoMapper::map)
                .toList();
    }

    public Optional<PhotoSessionDto> getPhotoSessionByClientId(Long clientId) {
        Optional<PhotoSession> photoSession = photoSessionRepository.findPhotoSessionByClientId(clientId);
        return photoSession.map(PhotoSessionDtoMapper::map);
    }

    public void createNewSession(PhotoSessionDto photoSessionToSave) {
        Payment payment = new Payment();
        Photos photos = new Photos();
        PhotoSession photoSession = new PhotoSession();
        Client client = clientRepository.findByLastName(photoSessionToSave.getClient().getLastName()).orElse(new Client());
        photoSession.setClient(client);
        photoSession.setPayment(payment);
        photoSession.setPhotos(photos);
        photoSession.setSessionDate(photoSession.getSessionDate());
        photoSession.setSessionType(photoSession.getSessionType());
        photoSessionRepository.save(photoSession);

    }

    public void deleteSession(long id) {
        photoSessionRepository.deleteById(id);
    }

    public void updateSession(PhotoSessionDto photoSessionDto, long id){
        PhotoSession photoSessionToUpdate = photoSessionRepository.findPhotoSessionById(id).orElseGet(PhotoSession::new);
        photoSessionToUpdate.setClient(photoSessionDto.getClient());
        photoSessionToUpdate.setSessionDate(photoSessionDto.getSessionDate());
        photoSessionToUpdate.setSessionType(photoSessionDto.getSessionType());
        photoSessionToUpdate.getPayment().setIsDepositPaid(photoSessionDto.getIsDepositPaid());
        photoSessionToUpdate.getPayment().setIsBasePaid(photoSessionDto.getIsBasePaid());
        photoSessionToUpdate.getPhotos().setSentToClientForChoose(photoSessionDto.getIsPhotosSentToClientForChoose());
        photoSessionToUpdate.getPhotos().setChosenByClient(photoSessionDto.getIsPhotosChosenByClient());
        photoSessionToUpdate.getPhotos().setAdditionalChosenByClient(photoSessionDto.getIsAdditionalPhotosChosenByClient());
        photoSessionToUpdate.getPayment().setIsAdditionalPaid(photoSessionDto.getIsAdditionalPaid());
        photoSessionToUpdate.setIsContractFinished(photoSessionDto.getIsContractFinished());
        photoSessionRepository.save(photoSessionToUpdate);
    }

    public Optional<PhotoSessionDto> getPhotoSessionByClient(Client client){
        return photoSessionRepository.findPhotoSessionByClient(client)
                .map(PhotoSessionDtoMapper::map);
    }

    public List<Client> getClientsByDate(LocalDateTime date) {
        Optional<PhotoSession> sessions = photoSessionRepository.findPhotoSessionBySessionDate(date);
        return sessions.stream()
                .map(PhotoSession::getClient)
                .collect(Collectors.toList());
    }

    public Optional<PhotoSessionDto> getPhotoSessionByDate(LocalDateTime date){
        return photoSessionRepository.findPhotoSessionBySessionDate(date)
                .map(PhotoSessionDtoMapper::map);
    }

    public List<PhotoSessionDto> findAllUnfinishedPhotoSession(){
        return photoSessionRepository.findAllByIsContractFinishedIsFalse().stream()
                .map(PhotoSessionDtoMapper::map)
                .toList();
    }
}
