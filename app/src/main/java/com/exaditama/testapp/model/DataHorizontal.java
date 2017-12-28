package com.exaditama.testapp.model;

/**
 * Created by kodeartisan on 28/12/17.
 */

public class DataHorizontal {

    private String title;
    private String imageUrl;
    private String description;
    private String time;

    public DataHorizontal(String title, String imageUrl, String description, String time) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
