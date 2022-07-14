
package com.example.filmnet.network.model;

import java.util.List;


import com.google.gson.annotations.SerializedName;


public class PromotedVideo {

    @SerializedName("status")
    
    public String status;
    @SerializedName("title")
    
    public String title;
    @SerializedName("page_title")
    
    public String pageTitle;
    @SerializedName("slug")
    
    public String slug;
    @SerializedName("summary")
    
    public String summary;
    @SerializedName("rate")
    
    public Float rate;
    @SerializedName("cover_image")
    
    public CoverImage__1 coverImage;
    @SerializedName("poster_image")
    
    public PosterImage__1 posterImage;
    @SerializedName("alter_cover_image")
    
    public AlterCoverImage__1 alterCoverImage;
    @SerializedName("type")
    
    public String type;
    @SerializedName("flag")
    
    public String flag;
    @SerializedName("conditional_flag")
    
    public String conditionalFlag;
    @SerializedName("age_restriction")
    
    public String ageRestriction;
    @SerializedName("year")
    
    public Integer year;
    @SerializedName("imdb_rank_percent")
    
    public Integer imdbRankPercent;
    @SerializedName("original_name")
    
    public String originalName;
    @SerializedName("duration")
    
    public String duration;
    @SerializedName("categories")
    
    public List<Category__1> categories = null;
    @SerializedName("id")
    
    public String id;
    @SerializedName("short_id")
    
    public String shortId;

}
