package com.programtom.zbd_api.model.charges;

@lombok.Data
public class CreateChargeRequest {
    private String amount;
    private String description;
    private Long expiresIn;
    private String internalId;
    private String callbackUrl;
}
