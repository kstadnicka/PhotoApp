package org.ks.photoapp.domain.photos;


import org.ks.photoapp.domain.photos.dto.PhotosDto;

public class PhotosDtoMapper {

    static PhotosDto map(Photos photos){
        return new PhotosDto(
                photos.getChosenByClient(),
                photos.getChosenByClient(),
                photos.getAdditionalChosenByClient()
        );
    }
}
