package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.charges.CreateChargeRequest;
import com.programtom.zbd_api.model.charges.CreateChargeResponse;
import com.programtom.zbd_api.model.charges.DecodeChargeResponse;

import java.util.HashMap;
import java.util.Map;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class ChargeApi {

    private final ZBDApi zbdApi;

    ChargeApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/charges/create">Create Charge</a>
     */
    public Response<CreateChargeResponse> createCharge(CreateChargeRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/charges")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/charges/get">Get Charge</a>
     */
    public Response<CreateChargeResponse> getCharge(String string) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/charges/" + string)
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/charges/decode">Decode Charge</a>
     */
    public Response<DecodeChargeResponse> decodeCharge(String invoice) {
        Map<String, String> invoiceMap = new HashMap<>();
        invoiceMap.put("invoice", invoice);
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/decode-invoice")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(invoiceMap))
                .asString());
    }
}
