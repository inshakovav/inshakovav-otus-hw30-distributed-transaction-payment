package com.example.payment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class PaymentRejectedMessage {
    private Long orderId;
    private Long paymentId;
    private String errorCode;
}
