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
import com.example.multigame.databinding.FragmentDragNDropBinding;
import com.example.multigame.databinding.FragmentFastTapGameBinding;
import com.example.multigame.databinding.FragmentStartGameBinding;
import com.example.multigame.utils.ActivityUtils;

public class DragNDropFragment extends Fragment {

    private FragmentStartGameBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start_game, container, false);

        binding.gameNameTitle.setText(R.string.drag_n_drop);

        binding.gameStartButton.setOnClickListener(v->{
            ActivityUtils.addFragmentToFragment(this, new FastTapGameFragment(), R.id.fast_tap_main_container );
        });


        return binding.getRoot();
    }
}