package com.snow.server5.model;

public class TokenModel implements ModelCarrier{

    private String token;
    private String memberId;
    private String imageUrl;

    public TokenModel(String token, String memberId, String imageUrl) {
        this.token = token;
        this.memberId = memberId;
        this.imageUrl = imageUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
