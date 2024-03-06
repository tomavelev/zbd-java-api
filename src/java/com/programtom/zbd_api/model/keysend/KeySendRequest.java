package com.programtom.zbd_api.model.keysend;

import java.util.List;

@lombok.Data
public class KeySendRequest {
    private String amount;
    private Object metadata;
    private List<Object> tlvRecords;
    private String callbackUrl;
    private String pubkey;
}
