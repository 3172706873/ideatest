package com.example.springboottest.controller;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.nlp.v20190408.NlpClient;
import com.tencentcloudapi.nlp.v20190408.models.KeywordsExtractionRequest;
import com.tencentcloudapi.nlp.v20190408.models.KeywordsExtractionResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KeywordsExtractionController {

    @RequestMapping("/keywordsExtraction")
    public String keywordsExtraction(String text) {
        System.out.println(text);
        try{
            Credential cred = new Credential("AKIDB7qsUpJIMBjjvQveLnysgDahZCeprV1N", "ECzU0GEtUqCH5by4tRjlfKq53lBKDxTv");

            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("nlp.tencentcloudapi.com");

            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);

            NlpClient client = new NlpClient(cred, "ap-guangzhou", clientProfile);

            String params = "{\"Text\":\"" + text + "\"}";
            KeywordsExtractionRequest req = KeywordsExtractionRequest.fromJsonString(params, KeywordsExtractionRequest.class);

            KeywordsExtractionResponse resp = client.KeywordsExtraction(req);

            return KeywordsExtractionRequest.toJsonString(resp);
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
            return e.toString();
        }
    }
}
