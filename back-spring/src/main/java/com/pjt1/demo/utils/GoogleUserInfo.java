package com.pjt1.demo.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class GoogleUserInfo {

    public static JsonNode getGoogleUserInfo(String accessToken) {
        // final String RequestUrl = "https://www.googleapis.com/oauth2/v1/userinfo";
        final String RequestUrl = "https://www.googleapis.com/oauth2/v2/userinfo";

        final HttpClient client = HttpClientBuilder.create().build();
        final HttpGet get = new HttpGet(RequestUrl);

        JsonNode returnNode = null;

        // add header
        get.addHeader("Authorization", "Bearer " + accessToken);

        try {
            final HttpResponse response = client.execute(get);
            final int responseCode = response.getStatusLine().getStatusCode();

            ObjectMapper mapper = new ObjectMapper();
            returnNode = mapper.readTree(response.getEntity().getContent());

            System.out.println("\nSending 'GET' request to URL : " + RequestUrl);
            System.out.println("Response Code : " + responseCode);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // clear resources
        }
        return returnNode;
    }
}