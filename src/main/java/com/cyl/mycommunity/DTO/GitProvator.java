package com.cyl.mycommunity.DTO;

import org.springframework.stereotype.Component;

@Component
public class GitProvator {
    String client_id;
    String redirect_uri;
    String code;
    String client_secret;
    String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "GitProvator{" +
                "client_id='" + client_id + '\'' +
                ", redirect_uri='" + redirect_uri + '\'' +
                ", code='" + code + '\'' +
                ", client_secret='" + client_secret + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
