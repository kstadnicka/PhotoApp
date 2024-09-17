package org.ks.photoapp.domain.photos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends CrudRepository<Photos, Long> {

    //boolean existsBySentToClientForChoose(boolean sentToClient);
   // boolean existsByChosenByClient(boolean chosenByClient);
    //boolean existsByAdditionalChosenByClient(boolean additionalChosenByClient);


}