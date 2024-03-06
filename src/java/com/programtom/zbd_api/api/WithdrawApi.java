package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.withdraw.WithdrawRequest;
import com.programtom.zbd_api.model.withdraw.WithdrawResponse;
import com.programtom.zbd_api.model.withdraw.WithdrawalResponse;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class WithdrawApi {

    private final ZBDApi zbdApi;

    WithdrawApi(ZBDApi zbdApi) {
        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/withdrawal-requests/create">...</a>
     */
    public Response<WithdrawalResponse> create(WithdrawRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/withdrawal-requests")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/withdrawal-requests/get">Get Withdraw request</a>
     */
    public Response<WithdrawResponse> getWithdrawRequest(String string) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/withdrawal-requests/" + string)
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }
}
