package org.ks.photoapp.domain.client;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.photoapp.domain.photoSession.PhotoSession;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String email;
    Long phoneNumber;
    @OneToMany(mappedBy = "client", cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    List<PhotoSession> photoSessions = new ArrayList<>();

}
