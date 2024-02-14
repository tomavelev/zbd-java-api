package com.programtom.zbd_api.model.callback;


import java.time.OffsetDateTime;

@lombok.Data
public class Withdrawal {
    private String amount;
    private String callbackURL;
    private OffsetDateTime createdAt;
    private String description;
    private OffsetDateTime expiresAt;
    private String fee;
    private String id;
    private Object internalID;
    private Invoice invoice;
    private String status;
    private String unit;
}
