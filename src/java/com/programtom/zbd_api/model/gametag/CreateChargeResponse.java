package com.programtom.zbd_api.model.gametag;

@lombok.Data
public class CreateChargeResponse {

    private String amount;
    private String createdAt;
    private String status;
    private String unit;
    private String internalId;
    private String callbackUrl;
    private String description;
    private String invoiceRequest;
    private String invoiceExpiresAt;
    private String invoiceDescriptionHash;
}
