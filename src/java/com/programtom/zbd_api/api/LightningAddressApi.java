package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.lightening_address.*;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class LightningAddressApi {

    private final String hostBase;

    private final String apiKey;

    LightningAddressApi(String hostBase, String apiKey) {
        this.hostBase = hostBase;
        this.apiKey = apiKey;
    }

    /**
     * <a href="https://zbd.dev/api-reference/lightning-address/validate">Validate Lightning Address</a>
     */
    public Response<ValidateLNResponse> validateLightningAddress(String address) {
        return call(() -> Unirest.get(hostBase + "v0/ln-address/validate/" + address)
                .header("apikey", apiKey)
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/lightning-address/create">Generate a payment request for a Lightning Address.</a>
     */
    public Response<CreateChargeResponse> createLNCharge(CreateChargeRequest request) {
        return call(() -> Unirest.post(hostBase + "v0/ln-address/fetch-charge")
                .header("apikey", apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/lightning-address/create">Pay to Lightning Address</a>
     */
    public Response<PayToLightingResponse> payToLightning(PayToLightingRequest request) {
        return call(() -> Unirest.post(hostBase + "v0/ln-address/send-payment")
                .header("apikey", apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

}
