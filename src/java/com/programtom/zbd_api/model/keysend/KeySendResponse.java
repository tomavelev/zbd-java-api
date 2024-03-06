package com.programtom.zbd_api.model.keysend;

@lombok.Data
public class KeySendResponse {
    private String keysendId;
    private String paymentId;
    private Transaction transaction;
}
