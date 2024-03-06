package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.gametag.*;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class ZbdGametagApi {

    private final ZBDApi zbdApi;

    ZbdGametagApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }


    /**
     * <a href="https://zbd.dev/api-reference/zbd-gamertag/send">Pay to ZBD Gamertag</a>
     */
    public Response<SendPaymentResponse> payToZBDGamertag(SendPaymentRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/gametag/send-payment")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/zbd-gamertag/get">Get Payment</a>
     */
    public Response<SendPaymentResponse> getPayment(String id) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/gamertag/transaction/" + id)
                .header("apikey", zbdApi.apiKey)
                .asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/zbd-gamertag/create">Create Charge</a>
     */
    public Response<CreateChargeResponse> createCharge(CreateChargeRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/gametag/charges")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());

    }

    /**
     * <a href="https://zbd.dev/api-reference/zbd-gamertag/get-userid">Get ID by ZBD Gamertag</a>
     */
    public Response<ZbdUser> getIDbyZbdGamertag(String id) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/gamertag/transaction/" + id)
                .header("apikey", zbdApi.apiKey).asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/zbd-gamertag/get-gamertag">Get Gamertag By ZBD ID</a>
     */
    public Response<Gamertag> getGamertagByZbdId(String id) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/gamertag/user-id/" + id)
                .header("apikey", zbdApi.apiKey).asString());
    }
}
