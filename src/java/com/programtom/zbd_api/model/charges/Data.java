
// Data.java

package com.programtom.zbd_api.model.charges;

import java.time.OffsetDateTime;
import java.util.UUID;

@lombok.Data
public class Data {
    private UUID id;
    private String unit;
    private Long slots;
    private String minAmount;
    private String maxAmount;
    private OffsetDateTime createdAt;
    private OffsetDateTime expiresAt;
    private String internalID;
    private String description;
    private String callbackURL;
    private Long allowedSlots;
    private String successMessage;
    private String status;
    private Invoice invoice;
}
