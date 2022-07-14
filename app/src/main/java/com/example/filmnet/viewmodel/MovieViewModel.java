package com.example.filmnet.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.filmnet.network.model.MovieResponseBean;
import com.example.filmnet.repository.MovieRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Observable;

@HiltViewModel
public class MovieViewModel extends AndroidViewModel {

    @Inject
    MovieRepository repository;

    @Inject
    public MovieViewModel(@NonNull Application application) {
        super(application);
    }

    public Observable<MovieResponseBean> getMovieListVM(String query) {
        return repository.getMovieListRepo(query);
    }
}
