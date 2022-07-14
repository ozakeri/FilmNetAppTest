
package com.example.filmnet.network.model;



import com.google.gson.annotations.SerializedName;


public class Widget {

    @SerializedName("type")
    
    public String type;
    @SerializedName("configuration")
    
    public Configuration configuration;
    @SerializedName("display_title")
    
    public String displayTitle;
    @SerializedName("column")
    
    public Integer column;
    @SerializedName("row")
    
    public Integer row;
    @SerializedName("id")
    
    public String id;

}
