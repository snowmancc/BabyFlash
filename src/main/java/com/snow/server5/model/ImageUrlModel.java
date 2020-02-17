package com.snow.server5.model;

public class ImageUrlModel implements ModelCarrier{

    private String imageUrl;

    public ImageUrlModel(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
