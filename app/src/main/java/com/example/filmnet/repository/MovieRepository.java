package com.example.filmnet.repository;

import com.example.filmnet.network.Api;
import com.example.filmnet.network.model.MovieResponseBean;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class MovieRepository {

    Api api;

    @Inject
    public MovieRepository(Api api) {
        this.api = api;
    }

    public Observable<MovieResponseBean> getMovieListRepo(String query) {
        return api.getMovieList(query);
    }
}
