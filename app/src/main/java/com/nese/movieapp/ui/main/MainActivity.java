package com.nese.movieapp.ui.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.nese.movieapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager viewPager = findViewById(R.id.viewpager);

        TabPageAdapter tabPageAdapter = new TabPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabPageAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }
}