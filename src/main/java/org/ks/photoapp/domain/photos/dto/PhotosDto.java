package org.ks.photoapp.domain.photos.dto;

import lombok.Data;

@Data
public class PhotosDto {
    Boolean isPhotosSentToClientForChoose;
    Boolean isPhotosChosenByClient;
    Boolean isAdditionalPhotosChosenByClient;

    public PhotosDto() {
    }

    public PhotosDto(Boolean isPhotosSentToClientForChoose, Boolean isPhotosChosenByClient,
                     Boolean isAdditionalPhotosChosenByClient) {
        this.isPhotosSentToClientForChoose = isPhotosSentToClientForChoose;
        this.isPhotosChosenByClient = isPhotosChosenByClient;
        this.isAdditionalPhotosChosenByClient = isAdditionalPhotosChosenByClient;
    }
}
