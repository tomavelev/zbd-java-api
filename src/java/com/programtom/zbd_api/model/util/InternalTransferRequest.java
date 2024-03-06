package com.programtom.zbd_api.model.util;

@lombok.Data
public class InternalTransferRequest {
    private String amount;
    private String receiverWalletId;
}
