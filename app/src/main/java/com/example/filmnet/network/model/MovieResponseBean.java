
package com.example.filmnet.network.model;



import com.google.gson.annotations.SerializedName;


public class MovieResponseBean {

    @SerializedName("data")
    
    public Data data;
    @SerializedName("meta")
    
    public Meta meta;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
