package com.programtom.zbd_api.model.lightening_address;

@lombok.Data
public class Metadata {
    private Long minSendable;
    private Long maxSendable;
    private Long commentAllowed;
    private String tag;
    private String metadata;
    private String callback;
    private PayerData payerData;
    private Boolean disposable;
}