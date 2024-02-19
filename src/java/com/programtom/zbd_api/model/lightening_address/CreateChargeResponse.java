package com.programtom.zbd_api.model.lightening_address;

import com.programtom.zbd_api.model.charges.Invoice;

@lombok.Data
public class CreateChargeResponse {
    private String lnaddress;
    private String amount;
    private Invoice invoice;
}
