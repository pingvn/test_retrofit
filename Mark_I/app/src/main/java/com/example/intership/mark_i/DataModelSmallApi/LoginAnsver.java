package com.example.intership.mark_i.DataModelSmallApi;

public class LoginAnsver {
    String success;
    String token_auth;
    String user_id;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getToken_auth() {
        return token_auth;
    }

    public void setToken_auth(String token_auth) {
        this.token_auth = token_auth;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
