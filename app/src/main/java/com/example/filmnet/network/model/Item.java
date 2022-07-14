
package com.example.filmnet.network.model;




import com.google.gson.annotations.SerializedName;


public class Item {

    @SerializedName("person_id")
    
    public String personId;
    @SerializedName("order")
    
    public Integer order;
    @SerializedName("person")
    
    public Person person;

}
