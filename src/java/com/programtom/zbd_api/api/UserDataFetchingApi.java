package com.programtom.zbd_api.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.wallet.WalletDataResponse;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class UserDataFetchingApi {

    private final ZBDApi zbdApi;

    UserDataFetchingApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/oauth2/get-user">...</a>
     */
    public String getUser(String userToken) {

        try {
            String sb = zbdApi.hostBase +
                        "v1/oauth2/user";
            HttpResponse<String> response = Unirest.get(sb)
                    .header("apikey", zbdApi.apiKey)
                    .header("usertoken", userToken)
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * <a href="https://zbd.dev/api-reference/oauth2/get-wallet">...</a>
     */
    public Response<WalletDataResponse> getWallet(String userToken) {
        return call(() -> Unirest.get(zbdApi.hostBase +
                                      "v1/oauth2/wallet")
                .header("apikey", zbdApi.apiKey)
                .header("usertoken", userToken)
                .asString());
    }


}
