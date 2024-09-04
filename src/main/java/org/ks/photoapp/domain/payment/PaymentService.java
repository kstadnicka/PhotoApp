package org.ks.photoapp.domain.payment;

import org.ks.photoapp.domain.payment.dto.PaymentDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Optional<PaymentDto> findPaymentById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentDtoMapper::map);
    }

    public Optional<PaymentDto> findPaymentsWithDepositPaid(Boolean isDepositPaid) {
        return paymentRepository.findPaymentByIsDepositPaid(isDepositPaid)
                .map(PaymentDtoMapper::map);
    }
    public Optional<PaymentDto> findPaymentsWithBasePaid(Boolean isBasePaid) {
        return paymentRepository.findPaymentByIsBasePaid(isBasePaid)
                .map(PaymentDtoMapper::map);
    }
    public Optional<PaymentDto> findPaymentsWithAdditionalPaid(Boolean isAdditionalPaid) {
        return paymentRepository.findPaymentByIsAdditionalPaid(isAdditionalPaid)
                .map(PaymentDtoMapper::map);
    }
}
