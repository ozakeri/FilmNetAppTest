package com.example.filmnet.network;

import com.example.filmnet.network.model.MovieResponseBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Api {

    @GET("/search")
    Observable<MovieResponseBean> getMovieList(@Query("query") String query);

}
