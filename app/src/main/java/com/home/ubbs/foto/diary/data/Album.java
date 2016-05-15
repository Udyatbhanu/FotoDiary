package com.home.ubbs.foto.diary.data;

/**
 * Created by udyatbhanu-mac on 7/11/15.
 */
public class Album {

    private String title;
    private String description;
    private String url;
    private String date;
    private String location;



    public Album(String title, String location, String description) {
        this.title = title;
        this.location = location;
        this.description = description;
    }

    public Album(){

    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
