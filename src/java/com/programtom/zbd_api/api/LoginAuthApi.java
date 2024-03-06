package com.programtom.zbd_api.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.programtom.zbd_api.model.auth.AuthorizationRequest;
import com.programtom.zbd_api.model.auth.FetchAccessTokenRequest;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class LoginAuthApi {

    private final ZBDApi zbdApi;

    LoginAuthApi(ZBDApi zbdApi) {

        this.zbdApi = zbdApi;
    }

    /**
     * <a href="https://zbd.dev/api-reference/oauth2/authorization">...</a>
     */
    public String getAuthorization(AuthorizationRequest request) {

        try {
            StringBuilder sb = new StringBuilder();
            sb.append(zbdApi.hostBase);
            sb.append("v1/oauth2/authorize?client_id=");
            sb.append(encodeParam(request.getClient_id()));
            sb.append("&response_type=");
            sb.append(encodeParam(request.getResponse_type()));
            sb.append("&redirect_uri=");
            sb.append(encodeParam(request.getRedirect_uri()));
            sb.append("&code_challenge_method=");
            sb.append(encodeParam(request.getCode_challenge_method()));
            sb.append("&scope=");
            sb.append(encodeParam(request.getScope()));
            HttpResponse<String> response = Unirest.get(sb.toString())
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }

    private String encodeParam(String clientId) {
        return URLEncoder.encode(clientId, StandardCharsets.UTF_8);
    }

    public String fetchOrRefreshAccessToken(FetchAccessTokenRequest request) {
        try {
            HttpResponse<String> response = Unirest.post(zbdApi.hostBase + "v1/oauth2/token")
                    .body(ZBDApi.gson.toJson(request))
                    .asString();
            return response.getBody();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
