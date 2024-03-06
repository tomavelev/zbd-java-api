package com.programtom.zbd_api.model.util;

@lombok.Data
public class IpSupportResponse {
    private String ipAddress;
    private String ipRegion;
    private String ipCountry;
    private Boolean isSupported;
}
