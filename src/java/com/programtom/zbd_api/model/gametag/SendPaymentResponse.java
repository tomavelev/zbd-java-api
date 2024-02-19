package com.programtom.zbd_api.model.gametag;

import java.util.UUID;

@lombok.Data
public class SendPaymentResponse {
    private UUID id;

    private String status;
    private UUID receiverId;
    private UUID transactionId;
    private String amount;
    private String comment;
    private String settledAt;
}
