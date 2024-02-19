package com.programtom.zbd_api;


import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.charges.CreateChargeRequest;
import com.programtom.zbd_api.model.charges.CreateChargeResponse;

import java.util.UUID;

public class TestZbdApi {
    public static void main(String[] args) {
        String apiKey = "";
        ZBDApi zbdApi = new ZBDApi.Builder().setProduction(false).setApiKey(apiKey).build();


        CreateChargeRequest chargeRequest = new CreateChargeRequest();
        chargeRequest.setAmount("1001");
        chargeRequest.setCallbackUrl("https://ngrok-free.app/PaymentCallback");
        chargeRequest.setInternalId(UUID.randomUUID().toString());
        chargeRequest.setDescription("testing");
        chargeRequest.setExpiresIn(30L);
        Response<CreateChargeResponse> charge = zbdApi.charge.createCharge(chargeRequest);
        System.out.println(charge);
    }
}
