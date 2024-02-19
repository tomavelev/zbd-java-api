package com.programtom.zbd_api.model.lightening_address;

import lombok.Data;

@Data
public class PayToLightingResponse {


    private String id;
    private String fee;
    private String unit;
    private String amount;
    private String invoice;
    private String preimage;
    private String walletId;
    private String transactionId;
    private String callbackUrl;
    private String internalId;
    private String comment;
    private String processedAt;
    private String createdAt;
    private String status;

}
