package com.example.multigame.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.multigame.R;
import com.example.multigame.databinding.FragmentFastTapBinding;
import com.example.multigame.databinding.FragmentFastTapGameBinding;

public class FastTapGameFragment extends Fragment {

    private static final int START_TIME = 20;
    private int currentTime = START_TIME;
    private boolean isLongTap;
    private int currentScore;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentFastTapGameBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fast_tap_game, container, false);

//        String a = "";
//        System.out.println("multiGame" + a);
//
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                binding.time.setText(getString(R.string.time_left, 12))
//            }
//        });
//        binding.getRoot().setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                return false;
//            }
//        });
//        if (Math.random() > 0.5)


            return binding.getRoot();
    }
}
