package org.ks.photoapp.domain.photoSession;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.photoapp.domain.client.Client;
import org.ks.photoapp.domain.payment.Payment;
import org.ks.photoapp.domain.photos.Photos;
import org.ks.photoapp.domain.sessionType.SessionType;


import java.time.LocalDateTime;
@Entity
@Data
public class PhotoSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;
    LocalDateTime sessionDate;
    @Enumerated(EnumType.STRING)
    SessionType sessionType;
    @OneToOne
    @JoinColumn(name = "payment_id")
    Payment payment;
    @OneToOne
    @JoinColumn(name = "photos_id")
    Photos photos;
    Boolean isContractFinished;

    public PhotoSession() {
    }
    
}
