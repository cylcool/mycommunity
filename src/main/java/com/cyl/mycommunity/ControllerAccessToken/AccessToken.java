package com.cyl.mycommunity.ControllerAccessToken;
import com.alibaba.fastjson.JSON;
import com.cyl.mycommunity.DTO.GitProvator;

import com.cyl.mycommunity.DTO.Userinfo;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessToken {
    private String accessToken = null;
    public String getAccessToken(GitProvator provitor){
         MediaType json = MediaType.parse("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(json, JSON.toJSONString(provitor));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            accessToken = response.body().string().split("&")[0].split("=")[1];
            return accessToken;
        } catch (IOException e) {
            return null;
        }
    }

    public Userinfo getUser(){
        OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://api.github.com/user?access_token=" + accessToken ).build();
            try (Response response = client.newCall(request).execute()) {
                String user = response.body().string();
                System.out.println(user);
                Userinfo userinfo = JSON.parseObject(user, Userinfo.class);
                return userinfo;
            } catch (IOException e) {
                return null;
            }

    }
}
