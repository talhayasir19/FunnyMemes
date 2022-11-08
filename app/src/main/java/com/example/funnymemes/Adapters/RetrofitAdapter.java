package com.example.funnymemes.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.funnymemes.R;
import com.example.funnymemes.RetrofitService.RetrofitModel;
import com.example.funnymemes.SingleImageActivity;

import java.util.ArrayList;
import java.util.List;

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.ViewHolder> {

    Context context;
    List<RetrofitModel> retrofitModelList;
    Onclick onclick;

    public RetrofitAdapter(Context context, List<RetrofitModel> retrofitModelList) {
        this.context = context;
        this.retrofitModelList = retrofitModelList;
    }
    public void setOnClick(Onclick onclick){
          this.onclick=onclick;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.rv_image_item, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(retrofitModelList.get(position).getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.ivImage);
        
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick.onclick(v,position);

            }
        });
    }

    @Override
    public int getItemCount() {
        return retrofitModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.iv_image);
        }
    }
    public interface Onclick{
        Void onclick(View view,int position);
    }
}
