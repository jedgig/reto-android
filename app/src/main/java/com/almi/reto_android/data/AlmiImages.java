package com.almi.reto_android.data;

import java.io.Serializable;

public class AlmiImages implements Serializable {
    private String Image;

    public AlmiImages(String image) {
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
