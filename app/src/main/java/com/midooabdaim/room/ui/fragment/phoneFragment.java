package com.midooabdaim.room.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.midooabdaim.room.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class emptyFragment extends BaseFragment {


    public emptyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        return inflater.inflate(R.layout.fragment_empty, container, false);
    }

    @Override
    public void onStart() {
        intialFragment();
        super.onStart();
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }
}
