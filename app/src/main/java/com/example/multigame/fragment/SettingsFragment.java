package com.example.multigame.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.multigame.R;
import com.example.multigame.activity.CreatePlayerActivity;
import com.example.multigame.activity.DisplayPlayerActivity;
import com.example.multigame.activity.MainActivity;
import com.example.multigame.activity.ResumeActivity;
import com.example.multigame.databinding.FragmentIpacBinding;
import com.example.multigame.databinding.FragmentSettingsBinding;
import com.example.multigame.manager.PlayerManager;
import com.example.multigame.model.Player;
import com.example.multigame.utils.ActivityUtils;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);

        Player player = PlayerManager.getInstance().getPlayer();

        binding.dragBestScore.setText(String.valueOf(player.getDragScore()));
        binding.tapBestScore.setText(String.valueOf(player.getTapScore()));
        binding.swipeBestScore.setText(String.valueOf(player.getSwipeScore()));

        binding.logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.launchActivity(((AppCompatActivity)getActivity()), CreatePlayerActivity.class);
            }
        });

        binding.changePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.launchActivity(((AppCompatActivity)getActivity()), DisplayPlayerActivity.class);
            }
        });


        return binding.getRoot();
    }
}
