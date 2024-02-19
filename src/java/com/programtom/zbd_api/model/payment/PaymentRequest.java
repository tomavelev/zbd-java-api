package com.programtom.zbd_api.model.payment;

@lombok.Data
public class PaymentRequest {

    private String amount;
    private String description;
    private String invoice;
    private String internalId;
    private String callbackUrl;

}
