package com.programtom.zbd_api.model.gametag;

@lombok.Data
public class SendPaymentRequest {
    private String amount;
    private String gamertag;
    private String description;
}
