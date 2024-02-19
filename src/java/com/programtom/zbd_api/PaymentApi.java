package com.programtom.zbd_api;

import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.payment.PaymentRequest;
import com.programtom.zbd_api.model.payment.PaymentResponse;

import java.lang.reflect.Type;

public class PaymentApi {

    private final String hostBase;

    private final String apiKey;

    PaymentApi(String hostBase, String apiKey) {
        this.hostBase = hostBase;
        this.apiKey = apiKey;
    }

    public Response<PaymentResponse> sendPayment(PaymentRequest request) {

        try {
            HttpResponse<String> response = Unirest.post(hostBase + "v0/payments")
                    .header("apikey", apiKey)
                    .header("Content-Type", "application/json")
                    .body(ZBDApi.gson.toJson(request))
                    .asString();
            Type type = new TypeToken<Response<PaymentResponse>>() {
            }.getType();

            return ZBDApi.gson.fromJson(response.getBody(), type);

        } catch (UnirestException e) {
            return new Response<>(e);
        }
    }

    public void getCharge() {

    }

    public void decodeCharge() {

    }
}
