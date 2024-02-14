package com.programtom.zbd_api;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.btcprice.BtcUsdPrice;

import java.lang.reflect.Type;

public class ZBDApi {

    private ZBDApi() {

    }

    public static final String PRODUCTION = "https://api.zebedee.io/";
    public static final String SANDBOX = "https://sandbox-api.zebedee.io/";

    @SuppressWarnings("unused")
    private String hostBase;
    @SuppressWarnings("unused")
    private String apiKey;

    public Response<BtcUsdPrice> getBtcPrice() {
        try {
            HttpResponse<String> response = Unirest.get("https://api.zebedee.io/v0/btcusd").asString();
            Type type = new TypeToken<Response<BtcUsdPrice>>() {
            }.getType();

            return new Gson().fromJson(response.getBody(), type);

        } catch (UnirestException e) {
            return new Response<>(e);
        }
    }


    public static class Builder {

        private boolean production;
        private String apiKey;


        public Builder setApiKey(String apiKey) {
            this.apiKey = apiKey;
            return this;
        }

        public Builder setProduction(boolean production) {
            this.production = production;
            return this;
        }

        public ZBDApi build() {
            ZBDApi zbdApi = new ZBDApi();

            if (production) {
                zbdApi.hostBase = PRODUCTION;
            } else {
                zbdApi.hostBase = SANDBOX;
            }
            zbdApi.apiKey = apiKey;
            return zbdApi;
        }
    }

}
