package com.programtom.zbd_api.model.util;

@lombok.Data
public class InternalTransferResponse {
    private String createdAt;
    private String receiveTxId;
    private String amount;
    private String receiverWalletId;
    private String senderWalletId;
    private String id;
    private String userId;
    private String sendTxId;
    private String status;
    private String updatedAt;
}
