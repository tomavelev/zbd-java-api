package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.voucher.CreateVoucherRequest;
import com.programtom.zbd_api.model.voucher.CreateVoucherResponse;
import com.programtom.zbd_api.model.voucher.VoucherDataResponse;

import java.util.HashMap;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class VoucherApi {

    private final ZBDApi zbdApi;

    VoucherApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }


    /**
     * <a href="https://zbd.dev/api-reference/vouchers/create">Create Voucher</a>
     */
    public Response<CreateVoucherResponse> createVoucher(CreateVoucherRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v1/create-voucher")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/vouchers/get">Get Voucher</a>
     */
    public Response<VoucherDataResponse> getVoucher(String string) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/vouchers/" + string)
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/vouchers/redeem">Redeem Voucher</a>
     */
    public Response<VoucherDataResponse> redeemVoucher(String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("code", code);
        return call(() -> Unirest.post(zbdApi.hostBase + "v1/redeem-voucher")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(map))
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/vouchers/revoke">Revoke Voucher</a>
     */
    public Response<VoucherDataResponse> revokeVoucher(String code) {
        HashMap<String, String> map = new HashMap<>();
        map.put("code", code);
        return call(() -> Unirest.post(zbdApi.hostBase + "v1/redeem-voucher")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(map))
                .asString());
    }


}

