Java Integration with the ZBD API (https://zbd.dev/api-reference/)

1) Configure if you are using SandBox or Production
   ZBDApi zbdApi = new ZBDApi.Builder().setProduction(false)

2) Set the API key grabbed from https://dashboard.zebedee.io/ .setApiKey(apiKey).build();

3) Use it.

At the current moment all endpoints are in todo. For example usage the public endpoint was integrated - getting the
btc-usd price

```
ZBDApi zbdApi = new ZBDApi.Builder()
   .setProduction(false)
   .setApiKey(apiKey)
   .build(); 
Response<BtcUsdPrice> response = zbdApi.getBtcPrice();
//        Response(success=true, 
                   data=BtcUsdPrice(btcUsdPrice=51471.095,
                   btcUsdTimestamp=1707939540), 
                   message=Successfully retrieved BTC USD price ticker information.,
  exception=null)
System.out.println(response);
```