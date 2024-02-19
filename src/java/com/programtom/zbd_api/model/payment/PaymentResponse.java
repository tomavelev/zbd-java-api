package com.programtom.zbd_api.model.payment;

import java.util.Date;
import java.util.UUID;

@lombok.Data
public class PaymentResponse {
    private UUID id;
    private String fee;
    private String unit;
    private String amount;
    private String invoice;
    private String preimage;
    private String internalId;
    private String processedAt;
    private String confirmedAt;
    private String description;
    private String status;
}
