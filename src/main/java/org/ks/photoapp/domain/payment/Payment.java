package org.ks.photoapp.domain.payment;

import jakarta.persistence.*;
import lombok.Data;
import org.ks.photoapp.domain.photoSession.PhotoSession;

@Data
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Float deposit;
    Float basePayment;
    Float additionalPayment;
    Boolean isDepositPaid;
    Boolean isBasePaid;
    Boolean isAdditionalPaid;
    @OneToOne(mappedBy = "payment")
    PhotoSession photoSession;



}
