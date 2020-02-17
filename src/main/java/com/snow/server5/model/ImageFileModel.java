package com.snow.server5.model;

import org.springframework.web.multipart.MultipartFile;

public class ImageFileModel implements ModelCarrier{
    private MultipartFile image;

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
