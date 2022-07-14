
package com.example.filmnet.network.model;

import java.util.List;


import com.google.gson.annotations.SerializedName;


public class Configuration {

    @SerializedName("items")
    
    public List<Item> items = null;
    @SerializedName("navigation_button")
    
    public NavigationButton navigationButton;
    @SerializedName("navigation_configuration")
    
    public NavigationConfiguration navigationConfiguration;

}
