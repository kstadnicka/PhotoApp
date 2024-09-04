package org.ks.photoapp.domain.photos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

@Repository
public interface PhotosRepository extends CrudRepository<Photos,Long> {

boolean findByIsPhotosSentToClientForChoose(long id);
boolean findByIsPhotosChosenByClient(long id);
boolean findByIsAdditionalPhotosChosenByClient(long id);
}