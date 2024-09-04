package org.ks.photoapp.domain.photoSession;


import org.ks.photoapp.domain.client.Client;
import org.ks.photoapp.domain.payment.Payment;
import org.ks.photoapp.domain.photoSession.dto.PhotoSessionDto;
import org.ks.photoapp.domain.photos.Photos;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoSessionService {
    PhotoSessionRepository photoSessionRepository;

    public List<PhotoSessionDto> getAllPhotoSession() {
        List<PhotoSession> photoSessions = (List<PhotoSession>) photoSessionRepository.findAll();
        return photoSessions.stream()
                .map(PhotoSessionDtoMapper::map)
                .toList();
    }


    public void createNewSession(PhotoSessionDto photoSessionDto) {
        Payment payment = new Payment();
        Photos photos = new Photos();
        Client client = new Client();
        PhotoSession photoSession = new PhotoSession();
        photoSession.setClient(client);
        photoSession.setPayment(payment);
        photoSession.setPhotos(photos);
        photoSession.setSessionDate(photoSession.getSessionDate());
        photoSession.setSessionType(photoSession.getSessionType());
        photoSessionRepository.save(photoSession);

    }

    public void updateSession(PhotoSessionDto photoSessionDto, long id){
        PhotoSession photoSessionToUpdate = photoSessionRepository.findPhotoSessionById(id).orElseGet(PhotoSession::new);
        photoSessionToUpdate.setClient(photoSessionDto.getClient());
        photoSessionToUpdate.setSessionDate(photoSessionDto.getSessionDate());
        photoSessionToUpdate.setSessionType(photoSessionDto.getSessionType());
        photoSessionToUpdate.getPayment().setIsDepositPaid(photoSessionDto.getIsDepositPaid());
        photoSessionToUpdate.getPayment().setIsBasePaid(photoSessionDto.getIsBasePaid());
        photoSessionToUpdate.getPhotos().setIsPhotosSentToClientForChoose(photoSessionDto.getIsPhotosSentToClientForChoose());
        photoSessionToUpdate.getPhotos().setIsPhotosChosenByClient(photoSessionDto.getIsPhotosChosenByClient());
        photoSessionToUpdate.getPhotos().setIsAdditionalPhotosChosenByClient(photoSessionDto.getIsAdditionalPhotosChosenByClient());
        photoSessionToUpdate.getPayment().setIsAdditionalPaid(photoSessionDto.getIsAdditionalPaid());
        photoSessionToUpdate.setIsContractFinished(photoSessionDto.getIsContractFinished());
        photoSessionRepository.save(photoSessionToUpdate);
    }

    public Optional<PhotoSessionDto> getClientByPhotoSession(Client client){
        return photoSessionRepository.findPhotoSessionByClient(client)
                .map(PhotoSessionDtoMapper::map);
    }

    public Optional<PhotoSessionDto> getPhotoSessionByDate(LocalDateTime date){
        return photoSessionRepository.findPhotoSessionBySessionDate(date)
                .map(PhotoSessionDtoMapper::map);
    }
}
