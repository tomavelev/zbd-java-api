package com.programtom.zbd_api.request.send_zbd_payment;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class MakeRequest {
    public static void main(String[] args) throws UnirestException {
        HttpResponse<String> response = Unirest.post("https://api.zebedee.io/v0/gamertag/send-payment")
                .header("apikey", "<apikey>")
                .header("Content-Type", "application/json")
                .body("{\n  \"amount\": \"<string>\",\n  \"gamertag\": \"<string>\",\n  \"description\": \"<string>\"\n}")
                .asString();
        System.out.println(response);
    }
}
