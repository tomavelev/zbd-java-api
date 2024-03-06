package com.programtom.zbd_api.model.voucher;

@lombok.Data
public class CreateVoucherResponse {
    private String createdAt;
    private String walletId;
    private String amount;
    private String unit;
    private String code;
    private String fee;
    private String description;
    private String createTransactionId;
    private String id;
}
