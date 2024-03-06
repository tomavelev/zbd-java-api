package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.lightening_address.*;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class LightningAddressApi {


    private final ZBDApi zbdApi;

    LightningAddressApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/lightning-address/validate">Validate Lightning Address</a>
     */
    public Response<ValidateLNResponse> validateLightningAddress(String address) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/ln-address/validate/" + address)
                .header("apikey", zbdApi.apiKey)
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/lightning-address/create">Generate a payment request for a Lightning Address.</a>
     */
    public Response<CreateChargeResponse> createLNCharge(CreateChargeRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/ln-address/fetch-charge")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/lightning-address/create">Pay to Lightning Address</a>
     */
    public Response<PayToLightingResponse> payToLightning(PayToLightingRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/ln-address/send-payment")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

}
