package com.programtom.zbd_api.request.get_payment;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class MakeRequest {
    public static void main(String[] args) throws UnirestException {
        HttpResponse<String> response = Unirest.get("https://api.zebedee.io/v0/gamertag/transaction/{id}")
                .header("apikey", "<apikey>")
                .asString();
        System.out.println(response);
    }
}
