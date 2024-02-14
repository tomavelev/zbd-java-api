// Data.java

package com.programtom.zbd_api.model.send_zbd_payment;

@lombok.Data
public class Request {
    @SuppressWarnings("SpellCheckingInspection")
    private String gamertag;
    private String amount;
    private String description;
}
