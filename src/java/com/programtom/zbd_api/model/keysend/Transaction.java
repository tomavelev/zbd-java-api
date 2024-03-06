package com.programtom.zbd_api.model.keysend;

@lombok.Data
public class Transaction {
    private String walletId;
    private String totalAmount;
    private String amount;
    private String fee;
    private String description;
    private String id;
    private String type;
    private String confirmedAt;
    private String status;
}
