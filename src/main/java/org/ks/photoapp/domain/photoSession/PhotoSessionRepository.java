package org.ks.photoapp.domain.photoSession;

import org.ks.photoapp.domain.client.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PhotoSessionRepository extends CrudRepository <PhotoSession,Long> {

    Optional<PhotoSession> findPhotoSessionById(long id);
    Optional<PhotoSession> findPhotoSessionByClient(Client client);
    Optional<PhotoSession> findPhotoSessionBySessionDate(LocalDateTime sessionDate);
    void deletePhotoSessionById(long id);
}
