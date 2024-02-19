package com.programtom.zbd_api.model.charges;

@lombok.Data
public class DecodeChargeResponse {
    private String amount;
    private String lnRequest;
    private String lnExpiresAt;
    private String network;
    private String description;
    private String descriptionHash;
    private String paymentHash;
    private String paymentSecret;
    private String payee;
    private String signature;
}