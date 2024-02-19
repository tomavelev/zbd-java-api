package com.programtom.zbd_api.web;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;

@RestController
public class PaymentCallback {


    @PostMapping("/PaymentCallback")
    public void paymentCallback(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request Method: " + request.getMethod());
        System.out.println("Request Headers: " + request.getHeaderNames());
         try(BufferedReader reader = request.getReader()) {
             reader.lines().forEach(System.out::println);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
    }


    @GetMapping("/PaymentCallback")
    public void testPaymentCallback(HttpServletRequest request, HttpServletResponse response) {

    }
}
