package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.keysend.KeySendRequest;
import com.programtom.zbd_api.model.keysend.KeySendResponse;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class KeysendApi {

    private final ZBDApi zbdApi;

    KeysendApi(ZBDApi zbdApi) {
        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/keysend/send">...</a>
     */
    public Response<KeySendResponse> sendKeySendPayment(KeySendRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "/v0/keysend-payment")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

}