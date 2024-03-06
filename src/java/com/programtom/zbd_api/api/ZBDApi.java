package com.programtom.zbd_api.api;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.programtom.zbd_api.model.Response;

import java.lang.reflect.Type;

public class ZBDApi {

    public ChargeApi charge;
    public PaymentApi payment;
    public LightningAddressApi ln;
    public ZbdGametagApi zbdGameTag;
    public UserDataFetchingApi userDataFetching;
    public LoginAuthApi loginAuth;
    public EmailApi email;
    public WithdrawApi withdraw;
    public VoucherApi voucher;
    public KeysendApi keysend;
    public WalletApi wallet;
    public StaticChargeApi staticCharge;
    public UtilityApi utility;

    private ZBDApi() {

    }

    static final Gson gson = new Gson();
    public static final String PRODUCTION = "https://api.zebedee.io/";
    public static final String SANDBOX = "https://sandbox-api.zebedee.io/";

    @SuppressWarnings("unused")
    String hostBase;
    @SuppressWarnings("unused")
    String apiKey;

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
            zbdApi.charge = new ChargeApi(zbdApi);
            zbdApi.payment = new PaymentApi(zbdApi);
            zbdApi.ln = new LightningAddressApi(zbdApi);
            zbdApi.email = new EmailApi(zbdApi);
            zbdApi.withdraw = new WithdrawApi(zbdApi);
            zbdApi.voucher = new VoucherApi(zbdApi);
            zbdApi.wallet = new WalletApi(zbdApi);
            zbdApi.keysend = new KeysendApi(zbdApi);
            zbdApi.utility = new UtilityApi(zbdApi);
            zbdApi.staticCharge = new StaticChargeApi(zbdApi);
            zbdApi.loginAuth = new LoginAuthApi(zbdApi);
            zbdApi.userDataFetching = new UserDataFetchingApi(zbdApi);
            zbdApi.zbdGameTag = new ZbdGametagApi(zbdApi);
            return zbdApi;
        }
    }

}
