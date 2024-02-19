package com.programtom.zbd_api.model.charges;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;

@lombok.Data
public class CreateChargeResponse {
    private String unit;
    private String amount;
    private Object confirmedAt;
    private String status;
    private String description;
    private String createdAt;
    private String expiresAt;
    private UUID id;
    private String internalId;
    private String callbackUrl;
    private Invoice invoice;
}
