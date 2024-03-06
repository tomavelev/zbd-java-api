package com.programtom.zbd_api.model.static_charge;

@lombok.Data
public class CreateChargeRequest {
    private Integer allowedSlots;
    private String minAmount;
    private String internalId;
    private String identifier;
    private String description;
    private String callbackUrl;
    private String maxAmount;
    private String successMessage;
}