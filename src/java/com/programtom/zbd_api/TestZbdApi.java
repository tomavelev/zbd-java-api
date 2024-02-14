package com.programtom.zbd_api;

import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.btcprice.BtcUsdPrice;

public class TestZbdApi {
    public static void main(String[] args) {
        String apiKey = "";
        ZBDApi zbdApi = new ZBDApi.Builder().setProduction(false).setApiKey(apiKey).build();


        Response<BtcUsdPrice> response = zbdApi.getBtcPrice();
//        Response(success=true, data=BtcUsdPrice(btcUsdPrice=51471.095, btcUsdTimestamp=1707939540), message=Successfully retrieved BTC USD price ticker information., exception=null)
        System.out.println(response);
    }
}
