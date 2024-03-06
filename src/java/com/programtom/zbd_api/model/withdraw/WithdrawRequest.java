package com.programtom.zbd_api.model.withdraw;

@lombok.Data
public class WithdrawRequest {
    private Integer expiresIn;
    private String internalId;
    private String amount;
    private String description;
    private String callbackUrl;
}
