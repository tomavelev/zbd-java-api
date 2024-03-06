package com.programtom.zbd_api.model.email;

@lombok.Data
public class EmailPaymentRequest {
    private String amount;
    private String comment;
    private String email;
}
