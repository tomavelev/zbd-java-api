package com.programtom.zbd_api.model.get_payment;

@lombok.Data
public class Request {

    private String amount;
    @SuppressWarnings("SpellCheckingInspection")
    private String gamertag;
    private String description;
    private int expiresIn;
    private String internalId;
    private String callbackUrl;

}
