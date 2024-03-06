package com.programtom.zbd_api.model.auth;

import lombok.Data;

@Data
public class AuthorizationRequest {
    private String client_id = "";
    private String response_type = "";
    private String redirect_uri = "";
    private String code_challenge_method = "";
    private String scope = "";
    private String code_challenge = "";
}
