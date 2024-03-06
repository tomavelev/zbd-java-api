package com.programtom.zbd_api.model.static_charge;

@lombok.Data
public class UpdateCharge {
    private Integer allowedSlots;
    private String minAmount;
    private String internalId;
    private String description;
    private String callbackUrl;
    private String maxAmount;
    private String successMessage;
}