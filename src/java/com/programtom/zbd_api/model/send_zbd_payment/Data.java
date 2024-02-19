// Data.java

package com.programtom.zbd_api.model.send_zbd_payment;

import java.time.OffsetDateTime;
import java.util.UUID;

@lombok.Data
public class Data {
    private UUID id;
    private String status;
    private UUID transactionID;
    private UUID receiverID;
    private String amount;
    private String comment;
    private String settledAt;
}
