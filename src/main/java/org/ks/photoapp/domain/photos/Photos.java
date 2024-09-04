package org.ks.photoapp.domain.photos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean isPhotosSentToClientForChoose;
    Boolean isPhotosChosenByClient;
    Boolean isAdditionalPhotosChosenByClient;
}
