
package com.example.filmnet.network.model;



import com.google.gson.annotations.SerializedName;


public class Meta {

    @SerializedName("total_items_count")
    
    public Integer totalItemsCount;
    @SerializedName("remaining_items_count")
    
    public Integer remainingItemsCount;
    @SerializedName("next_url")
    
    public String nextUrl;
    @SerializedName("operation_result")
    
    public String operationResult;
    @SerializedName("operation_result_code")
    
    public Integer operationResultCode;
    @SerializedName("display_message")
    
    public String displayMessage;
    @SerializedName("server_date_time")
    
    public String serverDateTime;

}
