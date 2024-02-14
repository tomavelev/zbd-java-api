package com.programtom.zbd_api.request.charges;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class MakeRequest {
    public static void main(String[] args) throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://api.zebedee.io/v0/charges")
                .header("apikey", "<apikey>")
                .header("Content-Type", "application/json")
                .body("{\n  \"amount\": \"<string>\",\n  \"description\": \"<string>\",\n  \"expiresIn\": 123,\n  \"callbackUrl\": \"<string>\",\n  \"internalId\": \"<string>\"\n}")
                .asString();

        System.out.println(response);
    }
}
