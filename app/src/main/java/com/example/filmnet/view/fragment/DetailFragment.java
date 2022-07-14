package com.example.filmnet.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.filmnet.R;
import com.example.filmnet.databinding.FragmentDetailBinding;
import com.example.filmnet.network.model.Video;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private Video video;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (getArguments() != null) {
            video = bundle.getParcelable("videos");

            Glide.with(binding.getRoot().getContext())
                    .load(video.posterImage.path)
                    .thumbnail(Glide.with(binding.getRoot().getContext()).load(R.drawable.loading))
                    .into(binding.appCompatImageView);

            binding.txtTitle.setText(video.title);
            binding.txtDescription.setText(video.summary);
        }

    }
}