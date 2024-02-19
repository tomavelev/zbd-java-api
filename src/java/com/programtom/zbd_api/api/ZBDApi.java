package com.programtom.zbd_api.api;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.btcprice.BtcUsdPrice;

import java.lang.reflect.Type;

public class ZBDApi {

    public ChargeApi charge;
    public PaymentApi payment;
    public LightningAddressApi ln;
    public ZbdGametagApi zbdGameTag;

    private ZBDApi() {

    }

    static final Gson gson = new Gson();
    public static final String PRODUCTION = "https://api.zebedee.io/";
    public static final String SANDBOX = "https://sandbox-api.zebedee.io/";

    @SuppressWarnings("unused")
    private String hostBase;
    @SuppressWarnings("unused")
    private String apiKey;


    public Response<BtcUsdPrice> getBtcPrice() {
        return call(() -> Unirest.get(hostBase + "v0/btcusd").asString());
    }

    static <T> Response<T> call(ZBDCall<T> zbdCall) {
        try {
            HttpResponse<String> logic = zbdCall.logic();
            Type type = new TypeToken<Response<T>>() {
            }.getType();

            return ZBDApi.gson.fromJson(logic.getBody(), type);
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
            zbdApi.charge = new ChargeApi(zbdApi.hostBase, zbdApi.apiKey);
            zbdApi.payment = new PaymentApi(zbdApi.hostBase, zbdApi.apiKey);
            zbdApi.ln = new LightningAddressApi(zbdApi.hostBase, zbdApi.apiKey);
            zbdApi.zbdGameTag = new ZbdGametagApi(zbdApi.hostBase, zbdApi.apiKey);
            //TODO email
            //TODO withdraw
            //TODO voucher
            //TODO wallet
            //TODO keysend
            //TODO utility
            //TODO static charge
            //ZBD Login
            //TODO Login & Authorization
            //TODO User Data Fetching
            return zbdApi;
        }
    }

}
