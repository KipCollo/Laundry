package com.kipcollo.controller;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import okhttp3.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MpesaPaymentServlet {
   // private static final long serialVersionUID = 1L;
    private static final String CONSUMER_KEY = "Your consumer key";
    private static final String CONSUMER_SECRET = "Your consumer secret";
    private static final String MPESA_API_URL = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
    private static final String CALLBACK_URL = "https://developer.safaricom.co.ke/APIs/";
    private static final String BUSINESS_SHORTCODE = "Business short code";
    private static final String PASSKEY = "Your passkey";

    @RequestMapping("/payment")
    protected void doPost(@RequestParam("amount") String amount,
                          @RequestParam("phone") String phone,
                          HttpServletResponse response) throws IOException {

        // Format phone number to international format if necessary
        if (phone.startsWith("0")) {
            phone = phone.replaceFirst("0", "254");
        }
        String accessToken = getAccessToken();
        if (accessToken != null) {
            initiateMpesaPayment(accessToken, amount, phone, response);
        } else {
            response.getWriter().println("Failed to get access token");
        }
    }

    private String getAccessToken() throws IOException {
        String credentials = CONSUMER_KEY + ":" + CONSUMER_SECRET;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
            .get()
            .addHeader("Authorization", "Basic " + encodedCredentials)
            .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                Map<String, Object> responseMap = new Gson().fromJson(responseBody, Map.class);
                return responseMap.get("access_token").toString();
            }
        }
        return null;
    }

    private void initiateMpesaPayment(String accessToken, String amount, String phone, HttpServletResponse response) throws IOException {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        String timestamp = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        String password = Base64.getEncoder().encodeToString((BUSINESS_SHORTCODE + PASSKEY + timestamp).getBytes());

        Map<String, Object> payload = new HashMap<>();
        payload.put("BusinessShortCode", BUSINESS_SHORTCODE);
        payload.put("Password", password);
        payload.put("Timestamp", timestamp);
        payload.put("TransactionType", "CustomerPayBillOnline");
        payload.put("Amount", amount);
        payload.put("PartyA", phone);
        payload.put("PartyB", BUSINESS_SHORTCODE);
        payload.put("PhoneNumber", phone);
        payload.put("CallBackURL", CALLBACK_URL);
        payload.put("AccountReference", "CompanyXLTD");
        payload.put("TransactionDesc", "Payment of X");

        RequestBody body = RequestBody.create(mediaType, new Gson().toJson(payload));
        Request mpesaRequest = new Request.Builder()
            .url(MPESA_API_URL)
            .post(body)
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer " + accessToken)
            .build();

        try (Response mpesaResponse = client.newCall(mpesaRequest).execute()) {
        if (mpesaResponse.isSuccessful()) {
            response.getWriter().println("Payment initiated successfully");
        } else {
            String responseBody = mpesaResponse.body().string();
            int statusCode = mpesaResponse.code();
            response.getWriter().println("Payment initiation failed");
            response.getWriter().println("Status Code: " + statusCode);
            response.getWriter().println("Response Body: " + responseBody);
        }
    }
    }
}
