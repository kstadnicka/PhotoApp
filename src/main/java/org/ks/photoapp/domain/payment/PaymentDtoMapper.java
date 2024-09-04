package org.ks.photoapp.domain.payment;


import org.ks.photoapp.domain.payment.dto.PaymentDto;

public class PaymentDtoMapper {
    static PaymentDto map(Payment payment){
        return new PaymentDto(
                payment.getDeposit(),
                payment.getBasePayment(),
                payment.getAdditionalPayment(),
                payment.getIsDepositPaid(),
                payment.getIsBasePaid(),
                payment.getIsAdditionalPaid());
    }
}
