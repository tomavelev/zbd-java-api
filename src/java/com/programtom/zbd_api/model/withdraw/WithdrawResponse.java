package com.programtom.zbd_api.model.withdraw;

@lombok.Data
public class WithdrawResponse {
    private String createdAt;
    private String internalId;
    private String unit;
    private String amount;
    private String description;
    private String callbackUrl;
    private String id;
    private WithdrawResponseInvoice invoice;
    private String expiresAt;
    private String status;
}
