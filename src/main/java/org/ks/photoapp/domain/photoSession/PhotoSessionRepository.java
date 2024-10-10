package org.ks.photoapp.domain.photoSession;

import org.ks.photoapp.domain.client.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhotoSessionRepository extends CrudRepository <PhotoSession,Long> {

    @Override
    List<PhotoSession> findAll();
    Optional<PhotoSession> findPhotoSessionByClientId(Long clientId);    Optional<PhotoSession> findPhotoSessionById(long id);
    Optional<PhotoSession> findPhotoSessionByClient(Client client);
    Optional<PhotoSession> findPhotoSessionBySessionDate(LocalDateTime sessionDate);
    void deletePhotoSessionById(long id);
    List<PhotoSession> findAllByIsContractFinishedIsFalse();
}
