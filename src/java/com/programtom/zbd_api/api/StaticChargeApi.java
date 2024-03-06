package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.charges.DecodeChargeResponse;
import com.programtom.zbd_api.model.static_charge.CreateChargeRequest;
import com.programtom.zbd_api.model.static_charge.CreateChargeResponse;
import com.programtom.zbd_api.model.static_charge.UpdateCharge;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class StaticChargeApi {

    private final ZBDApi zbdApi;

    StaticChargeApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }
    /**
     * <a href="https://zbd.dev/api-reference/static-charges/create">Create Static Charge</a>
     */
    public Response<CreateChargeResponse> createCharge(CreateChargeRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/static-charges")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/static-charges/get">Get Charge</a>
     */
    public Response<CreateChargeResponse> getCharge(String string) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/static-charges/" + string)
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/static-charges/update">Update Charge</a>
     */
    public Response<DecodeChargeResponse> updateCharge(String id, UpdateCharge updateCharge) {
        return call(() -> Unirest.patch(zbdApi.hostBase + "v0/static-charges/" + id)
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(updateCharge))
                .asString());
    }



}
