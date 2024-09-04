package org.ks.photoapp.domain.payment;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    Optional<Payment> findPaymentByIsDepositPaid(boolean isDepositPaid);
    Optional<Payment> findPaymentByIsBasePaid(boolean isBasePaid);
    Optional<Payment> findPaymentByIsAdditionalPaid(boolean isAdditionalPaid);
}
