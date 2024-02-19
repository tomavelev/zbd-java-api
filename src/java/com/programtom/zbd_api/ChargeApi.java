package com.programtom.zbd_api;

import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.charges.CreateChargeRequest;
import com.programtom.zbd_api.model.charges.CreateChargeResponse;

import java.lang.reflect.Type;

public class ChargeApi {

    private final String hostBase;

    private final String apiKey;

    ChargeApi(String hostBase, String apiKey) {
        this.hostBase = hostBase;
        this.apiKey = apiKey;
    }

    public Response<CreateChargeResponse> createCharge(CreateChargeRequest request) {

        try {
            HttpResponse<String> response = Unirest.post(hostBase + "v0/charges")
                    .header("apikey", apiKey)
                    .header("Content-Type", "application/json")
                    .body(ZBDApi.gson.toJson(request))
                    .asString();
            Type type = new TypeToken<Response<CreateChargeResponse>>() {
            }.getType();

            return ZBDApi.gson.fromJson(response.getBody(), type);

        } catch (UnirestException e) {
            return new Response<>(e);
        }
    }

    public Response<CreateChargeResponse> getCharge(String string) {
        try {
            HttpResponse<String> response = Unirest.get(hostBase + "v0/charges/" + string)
                    .header("apikey", apiKey)
                    .header("Content-Type", "application/json")
                    .asString();
            Type type = new TypeToken<Response<CreateChargeResponse>>() {
            }.getType();

            return ZBDApi.gson.fromJson(response.getBody(), type);

        } catch (UnirestException e) {
            return new Response<>(e);
        }
    }

    public void decodeCharge() {

    }
}
