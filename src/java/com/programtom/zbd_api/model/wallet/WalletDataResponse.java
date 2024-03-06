package com.programtom.zbd_api.model.wallet;

@lombok.Data
public class WalletDataResponse {
    private String balance;
    private WalletDataResponseRemainingAmountLimits remainingAmountLimits;
}