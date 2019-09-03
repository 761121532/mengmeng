package com.example.web.Entity;

public class imageEntity {
    private String src;
    private String text;
    private int imageLength;

    @Override
    public String toString() {
        return "imageEntity{" +
                "src='" + src + '\'' +
                ", text='" + text + '\'' +
                ", imageLength=" + imageLength +
                '}';
    }

    public int getImageLength() {
        return imageLength;
    }

    public void setImageLength(int imageLength) {
        this.imageLength = imageLength;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
