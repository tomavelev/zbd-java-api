package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.WalletBalanceResponse;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class WalletApi {

    private final ZBDApi zbdApi;

    WalletApi(ZBDApi zbdApi) {
        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/wallet/get">Wallet balance</a>
     */
    public Response<WalletBalanceResponse> getWalletBalance(String string) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/charges/" + string)
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }
}
