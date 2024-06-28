package site.toeicdoit.tx.service;

import com.siot.IamportRestClient.exception.IamportResponseException;
import site.toeicdoit.tx.domain.model.MessengerVo;
import site.toeicdoit.tx.domain.dto.PaymentDto;
import site.toeicdoit.tx.domain.model.PaymentModel;
import site.toeicdoit.tx.domain.model.ProductModel;
import site.toeicdoit.tx.domain.model.SubscribeModel;


import java.io.IOException;
import java.util.List;

public interface PaymentService {
    default PaymentModel dtoToEntity(PaymentDto dto){
        return PaymentModel.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .amount(dto.getAmount())
                .paymentUid(dto.getPaymentUid())
                .userId(UserModel.builder().id(dto.getUserId()).build())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .subscribeId(SubscribeModel.builder().id(dto.getSubscribeId()).build())
                .productId(ProductModel.builder().id(dto.getProductId()).build())
                .build();
    }

    default PaymentDto entityToDto(PaymentModel entity){
        return PaymentDto.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .amount(entity.getAmount())
                .paymentUid(entity.getPaymentUid())
                .userId(entity.getUserId().getId())
                .build();
    }

    MessengerVo save(PaymentDto dto);


    List<PaymentDto> getPaymentByUserId(Long userId);

    MessengerVo refundPayment(PaymentDto dto) throws IamportResponseException, IOException;
}
