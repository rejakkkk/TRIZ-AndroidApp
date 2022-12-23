package com.example.projectfrontend.classKontradiksiMatriks;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectfrontend.R;


public class tlkontradiksiActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.halaman_tlkontradiksi);
        ImageView gambarcontoh = findViewById(R.id.gambarcontoh);
        gambarcontoh.setImageResource(R.drawable.gambarcontohcm);
    }
}