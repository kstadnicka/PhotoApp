package org.ks.photoapp.domain.photoSession;


import org.ks.photoapp.domain.photoSession.dto.PhotoSessionDto;

public class PhotoSessionDtoMapper {
    static PhotoSessionDto map(PhotoSession photoSession) {
        return new PhotoSessionDto(
                photoSession.getClient(),
                photoSession.getId(),
                photoSession.getSessionDate(),
                photoSession.getSessionType(),
                photoSession.getPayment().getIsDepositPaid(),
                photoSession.getPayment().getIsBasePaid(),
                photoSession.getPhotos().getSentToClientForChoose(),
                photoSession.getPhotos().getChosenByClient(),
                photoSession.getPhotos().getAdditionalChosenByClient(),
                photoSession.getPayment().getIsAdditionalPaid(),
                photoSession.getIsContractFinished()
        );
    }
}
