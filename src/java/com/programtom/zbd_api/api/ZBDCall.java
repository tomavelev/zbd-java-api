package com.programtom.zbd_api.api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

interface ZBDCall<T> {

    HttpResponse<String> logic() throws UnirestException;
}