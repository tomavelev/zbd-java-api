package com.programtom.zbd_api.model.gametag;


@lombok.Data
public class CreateChargeRequest {
    private String amount;
    private String gamertag;
    private String description;
    private String internalId;
    private String callbackUrl;
    private Long expiresIn;
}
