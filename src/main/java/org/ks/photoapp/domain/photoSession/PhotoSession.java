package org.ks.photoapp.domain.photoSession;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.photoapp.domain.client.Client;
import org.ks.photoapp.domain.payment.Payment;
import org.ks.photoapp.domain.photos.Photos;
import org.ks.photoapp.domain.sessionType.SessionType;


import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
public class PhotoSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    Client client;
    LocalDateTime sessionDate;
    @Enumerated(EnumType.STRING)
    SessionType sessionType;
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "payment_id")
    Payment payment;
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinColumn(name = "photos_id")
    Photos photos;
    Boolean isContractFinished;

    public PhotoSession() {
    }

}
