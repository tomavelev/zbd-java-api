package com.programtom.zbd_api.model.get_payment;

import java.time.OffsetDateTime;
import java.util.UUID;

@lombok.Data
public class Data {
    private UUID id;
    private UUID receiverID;
    private String amount;
    private String fee;
    private String unit;
    private OffsetDateTime processedAt;
    private OffsetDateTime confirmedAt;
    private String comment;
    private String status;
}
