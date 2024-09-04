package org.ks.photoapp.domain.photos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotosService {

    PhotosRepository photosRepository;

    public boolean photosSentForChooseToClient(long id){
        return photosRepository.findByIsPhotosSentToClientForChoose(id);
    }

    public boolean photosChosenByClient(long id){
        return  photosRepository.findByIsPhotosChosenByClient(id);
    }

    public boolean additionalPhotosChosenByClient(long id){
        return photosRepository.findByIsAdditionalPhotosChosenByClient(id);
    }
}
