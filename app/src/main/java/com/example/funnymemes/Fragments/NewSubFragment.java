package com.example.funnymemes.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.funnymemes.Adapters.RetrofitAdapter;
import com.example.funnymemes.MainActivity;
import com.example.funnymemes.R;
import com.example.funnymemes.RetrofitService.RetrofitAlbum;
import com.example.funnymemes.RetrofitService.RetrofitModel;
import com.example.funnymemes.SingleImageActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewSubFragment extends Fragment {

    RecyclerView recyclerView;
    public static List<RetrofitModel> data;

    public NewSubFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_new_sub, container, false);

        recyclerView = rootView.findViewById(R.id.rv_imageRecycler);
        getProducts();

        return rootView;
    }

    private void getProducts() {
            Call<List<RetrofitModel>> apiCall = RetrofitAlbum.getInstance().getApi().getProducts();
        apiCall.enqueue(new Callback<List<RetrofitModel>>() {
            @Override
            public void onResponse(Call<List<RetrofitModel>> call, Response<List<RetrofitModel>> response) {
                  data = response.body();
                  setAdapter(data);
            }

            @Override
            public void onFailure(Call<List<RetrofitModel>> call, Throwable t) {

            }
        });
    }

    private void setAdapter(List<RetrofitModel> data) {

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), 2));
        RetrofitAdapter adapter = new RetrofitAdapter(getActivity().getApplicationContext(), data);
        adapter.setOnClick(new RetrofitAdapter.Onclick() {
            @Override
            public Void onclick(View view, int position) {
                Intent intent = new Intent(getActivity().getApplicationContext(), SingleImageActivity.class);
                //For setting selected image to load first
                intent.putExtra("position",position);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                return null;
            }
        });
        recyclerView.setAdapter(adapter);

    }

}