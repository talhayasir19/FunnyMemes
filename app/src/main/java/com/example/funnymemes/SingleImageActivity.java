package com.example.funnymemes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.example.funnymemes.Adapters.ViewPagerAdapter;
import com.example.funnymemes.Fragments.NewSubFragment;
import com.example.funnymemes.RetrofitService.RetrofitModel;

import java.util.ArrayList;
import java.util.List;

public class SingleImageActivity extends AppCompatActivity {

    ViewPager mViewPager;
    ArrayList<RetrofitModel> imageList=new ArrayList<>();
    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_image);
        //Initializing the ViewPager Object
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);

        //Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(this, NewSubFragment.data);


        //Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);
        //setting the starting position of the viewpager
        mViewPager.setCurrentItem(getIntent().getIntExtra("position",5));

    }
}