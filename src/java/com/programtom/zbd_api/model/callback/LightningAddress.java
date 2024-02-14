package com.programtom.zbd_api.model.callback;


import java.time.OffsetDateTime;

@lombok.Data
public class LightningAddress {
    private String amount;
    private String callbackURL;
    private OffsetDateTime confirmedAt;
    private OffsetDateTime createdAt;
    private String description;
    private String fee;
    private String id;
    private Object internalID;
    private String invoice;
    private String preimage;
    private String status;
    private String transactionID;
    private String unit;
    private String walletID;
}
