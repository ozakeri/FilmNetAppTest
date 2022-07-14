package com.example.filmnet.view.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.filmnet.R;
import com.example.filmnet.databinding.MovieItemsBinding;
import com.example.filmnet.network.model.Video;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.CustomView>{

    List<Video> videos;
    LayoutInflater layoutInflater;

    public MovieAdapter(List<Video> videos) {
        this.videos = videos;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        MovieItemsBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.movie_items,parent,false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int position) {
            holder.bind(videos.get(position));
            holder.binding.mainConstraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("videos", videos.get(position));
                    Navigation.findNavController(v).navigate(R.id.detailFragment,bundle);
                }
            });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public static class CustomView extends RecyclerView.ViewHolder {

        MovieItemsBinding binding;

        public CustomView(MovieItemsBinding binding) {
            super(binding.getRoot());
           this.binding = binding;

        }

        public void bind(Video video){
            binding.txtTitle.setText( "نام فیلم : " + video.getTitle());
            binding.txtCategory.setText("دسته بندی : " + video.getCategories().get(1).getItems().get(0).title);
            binding.txtDuration.setText("مدت زمان : " + video.duration);
            Glide.with(binding.getRoot().getContext())
                    .load(video.coverImage.path)
                    .thumbnail(Glide.with(binding.getRoot().getContext()).load(R.drawable.loading))
                    .into(binding.imgCover);
        }
    }
}
