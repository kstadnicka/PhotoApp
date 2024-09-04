package org.ks.photoapp.domain.payment;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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

}
