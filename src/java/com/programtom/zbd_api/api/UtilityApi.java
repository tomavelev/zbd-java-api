package com.programtom.zbd_api.api;

import com.mashape.unirest.http.Unirest;
import com.programtom.zbd_api.model.Response;
import com.programtom.zbd_api.model.btcprice.BtcUsdPrice;
import com.programtom.zbd_api.model.util.InternalTransferRequest;
import com.programtom.zbd_api.model.util.InternalTransferResponse;
import com.programtom.zbd_api.model.util.IpSupportResponse;
import com.programtom.zbd_api.model.util.ZBDIp;

import static com.programtom.zbd_api.api.ZBDApi.call;

public class UtilityApi {

    private final ZBDApi zbdApi;

    UtilityApi(ZBDApi zbdApi) {
        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/utils/btc-usd">...</a>
     */
    public Response<BtcUsdPrice> getBtcPrice() {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/btcusd").asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/utils/is-supported-region">Is IP in Supported Region</a>
     */
    public Response<IpSupportResponse> isIPSupportedRegion(String ip) {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/is-supported-region/" + ip)
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }

    /**
     * <a href="https://zbd.dev/api-reference/utils/ip">Get the official IP addresses of ZBD servers.</a>
     */
    public Response<ZBDIp> getZBDServers() {
        return call(() -> Unirest.get(zbdApi.hostBase + "v0/prod-ips/charges/")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .asString());
    }


    /**
     * <a href="https://zbd.dev/api-reference/internal-transfer/create">Create Internal Transfer</a>
     */
    public Response<InternalTransferResponse> createInternalTransfer(InternalTransferRequest request) {
        return call(() -> Unirest.post(zbdApi.hostBase + "v0/internal-transfer")
                .header("apikey", zbdApi.apiKey)
                .header("Content-Type", "application/json")
                .body(ZBDApi.gson.toJson(request))
                .asString());
    }

}
