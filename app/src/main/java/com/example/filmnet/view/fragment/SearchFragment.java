package com.example.filmnet.view.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.filmnet.R;
import com.example.filmnet.databinding.FragmentSearchBinding;
import com.example.filmnet.network.model.MovieResponseBean;
import com.example.filmnet.network.model.Video;
import com.example.filmnet.view.adapter.MovieAdapter;
import com.example.filmnet.viewmodel.MovieViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

@AndroidEntryPoint
public class SearchFragment extends Fragment {

    private FragmentSearchBinding binding;
    private CompositeDisposable compositeDisposable;
    private MovieViewModel viewModel;
    private MovieAdapter adapter;
    private List<Video> videoList = new ArrayList<>();
    private Handler handler;

    @Inject
    ConnectivityManager connectivityManager;

    @Inject
    NetworkRequest networkRequest;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false);
        setupSearchBox();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handler = new Handler(Looper.getMainLooper());
        compositeDisposable = new CompositeDisposable();
        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        // getData("سلام");

    }

    public void getData(String query) {
        System.out.println("query====" + query);
        videoList.clear();
        Disposable disposable = viewModel.getMovieListVM(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieResponseBean>() {
                    @Override
                    public void accept(MovieResponseBean movieResponseBean) throws Throwable {
                        hideProgress();
                        //System.out.println("displayMessage=====" + movieResponseBean.meta.displayMessage);
                        //System.out.println("coverImage=====" + movieResponseBean.data.videos.get(0).coverImage.path);
                        videoList = movieResponseBean.getData().getVideos();

                        if (videoList.size() == 0) {
                            binding.txtItemNotFound.setVisibility(View.VISIBLE);
                            binding.searchRecyclerView.setVisibility(View.INVISIBLE);
                        } else {
                            setupAdapter();
                            binding.txtItemNotFound.setVisibility(View.GONE);
                            binding.searchRecyclerView.setVisibility(View.VISIBLE);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        Log.e("Throwable", throwable.getMessage(), throwable);
                    }
                });
        compositeDisposable.add(disposable);
    }

    public void setupAdapter() {
        if (binding.searchRecyclerView.getAdapter() == null) {
            adapter = new MovieAdapter(videoList);
            binding.searchRecyclerView.setAdapter(adapter);
        }
    }

    private void setupSearchBox() {
        binding.edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                showProgress();
                binding.txtItemNotFound.setVisibility(View.GONE);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        checkConnection(s.toString());
                    }
                }, 2000);

            }
        });
    }

    public void showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    public void hideProgress() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

    public void checkConnection(String query) {
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@androidx.annotation.NonNull Network network) {
                Log.e("onAvailable", "onAvailable: ");
                binding.searchRecyclerView.setVisibility(View.INVISIBLE);
                getData(query);
            }

            @Override
            public void onLost(@androidx.annotation.NonNull Network network) {
                Log.e("onLost", "onLost: ");
                Snackbar.make(binding.constraintLayout, "Internet connection lost", 2000).show();
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback);
        } else {
            connectivityManager.registerNetworkCallback(networkRequest, networkCallback);
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

}