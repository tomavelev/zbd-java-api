package com.programtom.zbd_api.model.callback;


import java.time.OffsetDateTime;

@lombok.Data
public class Payment {
    private String amount;
    private OffsetDateTime confirmedAt;
    private String description;
    private String fee;
    private String id;
    private Object internalID;
    private String invoice;
    private String preimage;
    private OffsetDateTime processedAt;
    private String status;
    private String unit;
}
