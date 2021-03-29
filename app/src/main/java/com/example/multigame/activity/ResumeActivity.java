package com.example.multigame.activity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.multigame.R;
import com.example.multigame.dao.AppDatabase;
import com.example.multigame.databinding.ActivityResumeBinding;
import com.example.multigame.utils.ActivityUtils;

public class ResumeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityResumeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_resume);

        String game = getIntent().getStringExtra("gameName");
        binding.gameName.setText(game);

        int finalScore = getIntent().getIntExtra("score", 0);
        binding.finalScore.setText("Score: " + finalScore);




        binding.resumeMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.launchActivity(ResumeActivity.this, MainActivity.class);
            }
        });

        binding.resumeExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}