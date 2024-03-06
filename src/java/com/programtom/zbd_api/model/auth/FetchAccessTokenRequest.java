package com.programtom.zbd_api.model.auth;

@lombok.Data
public class FetchAccessTokenRequest {
    private String code;
    private String grant_type;
    private String client_secret;
    private String redirect_uri;
    private String client_id;
    private String code_verifier;

    private String refresh_token;
}
