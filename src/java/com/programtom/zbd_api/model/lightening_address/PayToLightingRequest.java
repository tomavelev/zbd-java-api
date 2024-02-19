package com.programtom.zbd_api.model.lightening_address;

import lombok.Data;

@Data
public class PayToLightingRequest {
    private String lnAddress;
    private String amount;
    private String comment;
    private String internalId;
    private String callbackUrl;
}
