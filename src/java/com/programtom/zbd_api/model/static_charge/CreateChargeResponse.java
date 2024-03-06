package com.programtom.zbd_api.model.static_charge;

import com.programtom.zbd_api.model.charges.Invoice;

@lombok.Data
public class CreateChargeResponse {
    private String minAmount;
    private String description;
    private String successMessage;
    private String expiresAt;
    private Integer allowedSlots;
    private String createdAt;
    private String internalId;
    private String unit;
    private Integer slots;
    private String callbackUrl;
    private String id;
    private Invoice invoice;
    private String maxAmount;
    private String status;
}