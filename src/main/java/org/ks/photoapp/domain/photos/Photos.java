package org.ks.photoapp.domain.photos;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.photoapp.domain.photoSession.PhotoSession;

@Data
@Entity
public class Photos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Boolean SentToClientForChoose;
    Boolean ChosenByClient;
    Boolean AdditionalChosenByClient;
    @OneToOne(mappedBy = "photos")
    PhotoSession photoSession;
}
