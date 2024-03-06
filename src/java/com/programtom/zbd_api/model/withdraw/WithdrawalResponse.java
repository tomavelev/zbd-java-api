package com.programtom.zbd_api.model.withdraw;

@lombok.Data
public class WithdrawalResponse {
    private String createdAt;
    private String internalId;
    private String unit;
    private String amount;
    private Object fee;
    private String description;
    private String callbackUrl;
    private String id;
    private WithdrawalInvoice invoice;
    private String expiresAt;
    private String status;
}