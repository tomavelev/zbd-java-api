package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.payment.PaymentRequest;
import com.programtom.zbd_api.model.payment.PaymentResponse;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class PaymentApi {

    private final String hostBase;

    private final String apiKey;

    PaymentApi(String hostBase, String apiKey) {
        this.hostBase = hostBase;
        this.apiKey = apiKey;
    }

    /**
     * <a href="https://zbd.dev/api-reference/payments/send">Send Payment</a>
     */
    public Response<PaymentResponse> sendPayment(PaymentRequest request) {
        return call(() -> Unirest.post(hostBase + "v0/payments")
                .header("apikey", apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/payments/get">Get Payment</a>
     */
    public Response<PaymentResponse> getPayment(String id) {
        return call(() -> Unirest.get(hostBase + "v0/payments/" + id)
                .header("apikey", apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }
}
