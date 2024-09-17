package org.ks.photoapp.domain.photos;

import org.springframework.stereotype.Service;

@Service
public class PhotosService {

    PhotosRepository photosRepository;

   // public boolean photosSentForChooseToClient(boolean sentToClient){
  //      return photosRepository.existsBySentToClientForChoose(sentToClient);
  //  }

  //  public boolean photosChosenByClient(boolean chosenByClient){
 //       return photosRepository.existsByChosenByClient(chosenByClient);
 //   }

  //  public boolean additionalPhotosChosenByClient(boolean additionalChosenByClient){
  //      return photosRepository.existsByAdditionalChosenByClient(additionalChosenByClient);
  //  }
}
