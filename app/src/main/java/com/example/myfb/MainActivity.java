package com.example.myfb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.myfb.DataSourse.Database;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Database database;
    ViewPager viewPager;
    MyFragmentAdapter adapter;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = new Database(this,Database.DATABASE_NAME, null, Database.DB_VERSION);
        viewPager = findViewById(R.id.fragment_pager);
        tabLayout=findViewById(R.id.tabs);
        adapter = new MyFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }


}
