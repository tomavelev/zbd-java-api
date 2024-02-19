package com.programtom.zbd_api.model.lightening_address;
import lombok.AllArgsConstructor;

@lombok.Data
public class CreateChargeRequest {
    private String lnaddress;
    private String amount;
    private String description;
}
