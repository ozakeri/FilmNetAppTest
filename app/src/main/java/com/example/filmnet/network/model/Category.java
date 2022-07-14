
package com.example.filmnet.network.model;

import java.util.List;



import com.google.gson.annotations.SerializedName;


public class Category {

    @SerializedName("type")
    public String type;
    @SerializedName("items")
    
    public List<Item__1> items = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Item__1> getItems() {
        return items;
    }

    public void setItems(List<Item__1> items) {
        this.items = items;
    }
}
