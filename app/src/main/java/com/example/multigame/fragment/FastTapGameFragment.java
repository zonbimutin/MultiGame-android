package com.example.multigame.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.multigame.R;
import com.example.multigame.activity.ResumeActivity;
import com.example.multigame.databinding.FragmentFastTapGameBinding;
import com.example.multigame.utils.ActivityUtils;

public class FastTapGameFragment extends Fragment {

    private static final int START_TIME = 20000;
    private int currentTime = START_TIME;
    private boolean isLongTap;
    private int currentScore;
    private CountDownTimer gameCounter;
    private FragmentFastTapGameBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fast_tap_game, container, false);



        startNewGame();


        return binding.getRoot();
    }

    public void setTapType(){
        binding.typeType.setText("");
        boolean type = Math.random() > 0.7 ? true : false;
        isLongTap = type;
        binding.typeType.setText(isLongTap ? "Long Tap" : "Tap");
        binding.typeType.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
    }

    public void setGameClickHandler(){

        binding.gameContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isLongTap){
                    setGameScore();
                    setTapType();

                }
            }
        });

        binding.gameContainer.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(isLongTap){
                    setGameScore();
                    setTapType();

                }
                return true;
            }
        });
    }

    public void setGameScore(){
        currentScore++;
        binding.currentScore.setText(getString(R.string.score, currentScore));
    }

    public void setGameCountDown(){

        gameCounter = new CountDownTimer(START_TIME, 1000) {

            public void onTick(long millisUntilFinished) {
                binding.timeLeft.setText(getString(R.string.time_left, millisUntilFinished / 1000));
            }


            public void onFinish() {

                binding.timeLeft.setText("done!");
                binding.gameContainer.setOnLongClickListener(null);
                binding.gameContainer.setOnClickListener(null);

                //TODO: lunch resume game page
                Intent intent = new Intent(getActivity(), ResumeActivity.class);
                intent.putExtra("score", currentScore);
                intent.putExtra("gameName", "Fast Tap");
                ActivityUtils.launchActivity(((AppCompatActivity)getActivity()),intent, true ,true);

            }
        }.start();

    }

    public void startNewGame(){

        currentScore = 0;
        binding.timeLeft.setText(getString(R.string.time_left, START_TIME / 1000));
        binding.currentScore.setText(getString(R.string.score, currentScore));

        setTapType();
        setGameClickHandler();
        setGameCountDown();

    }

    @Override
    public void onDestroyView() {
        gameCounter.cancel();
        super.onDestroyView();
    }
}
