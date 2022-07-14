
package com.example.filmnet.network.model;



import com.google.gson.annotations.SerializedName;


public class Person {

    @SerializedName("name")
    
    public String name;
    @SerializedName("name_en")
    
    public String nameEn;
    @SerializedName("summary")
    
    public String summary;
    @SerializedName("slug")
    
    public String slug;
    @SerializedName("id")
    
    public String id;
    @SerializedName("short_id")
    
    public String shortId;
    @SerializedName("avatar_image")
    
    public AvatarImage avatarImage;

}
