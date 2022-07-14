
package com.example.filmnet.network.model;

import java.util.List;


import com.google.gson.annotations.SerializedName;


public class Data {


    @SerializedName("videos")
    public List<Video> videos = null;

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
