package com.programtom.zbd_api.model.callback;

@lombok.Data
public class Charge {
    private String amount;
    private String callbackURL;
    private String description;
    private String id;
    private Object internalID;
    private String status;
    private String unit;
}
