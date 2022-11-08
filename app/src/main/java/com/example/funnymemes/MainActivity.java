package com.example.funnymemes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.funnymemes.Fragments.FavouriteFragment;
import com.example.funnymemes.Fragments.HomeFragment;
import com.example.funnymemes.Fragments.SaveFragment;
import com.example.funnymemes.Fragments.SettingFragment;
import com.example.funnymemes.Helpers.BottomNavigationViewHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId())   {
                    case R.id.action_home:
                        selectedFragment = HomeFragment.getInstance();
                        break;

                    case R.id.action_favourite:
                        selectedFragment = FavouriteFragment.getInstance();
                        break;

                    case R.id.action_save:
                        selectedFragment = SaveFragment.getInstance();
                        break;

                    case R.id.action_setting:
                        selectedFragment = SettingFragment.getInstance();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame,selectedFragment);
                transaction.commit();
                return true;
            }
        });
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame,HomeFragment.getInstance());
        transaction.commit();
    }

}