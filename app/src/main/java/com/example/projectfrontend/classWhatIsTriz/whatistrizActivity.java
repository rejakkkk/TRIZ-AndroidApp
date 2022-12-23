package com.example.projectfrontend.classWhatIsTriz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectfrontend.R;


public class whatistrizActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.halaman_whatistriz);
    }
}