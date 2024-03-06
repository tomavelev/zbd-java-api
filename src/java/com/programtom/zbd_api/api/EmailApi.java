package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.email.EmailPaymentRequest;
import com.programtom.zbd_api.model.email.EmailPaymentResponse;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class EmailApi {

    private final ZBDApi zbdApi;

    EmailApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/email/send">...</a>
     */
    public Response<EmailPaymentResponse> payToEmail(EmailPaymentRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/email/send-payment")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }
}
