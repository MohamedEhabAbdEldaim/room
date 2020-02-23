package com.midooabdaim.room.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.room.R;
import com.midooabdaim.room.adpter.usersAdapter;
import com.midooabdaim.room.data.local.DaoAccess;
import com.midooabdaim.room.data.local.item;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.midooabdaim.room.data.local.roomManger.getInstance;
import static com.midooabdaim.room.helper.HelperMethod.replaceFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class usersFragment extends BaseFragment {


    @BindView(R.id.fragment_users_rv)
    RecyclerView fragmentUsersRv;
    private Unbinder unbinder;
    private LinearLayoutManager linearLayoutManager;
    private usersAdapter usersAdapter;
    private List<item> list = new ArrayList<>();
    private DaoAccess dao;

    public usersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        unbinder = ButterKnife.bind(this, view);
        dao = getInstance(getActivity()).daoAccess();
        intial();
        setData();
        return view;
    }

    private void intial() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentUsersRv.setLayoutManager(linearLayoutManager);
        usersAdapter = new usersAdapter(getActivity(), list);
        fragmentUsersRv.setAdapter(usersAdapter);

    }

    private void setData() {

        try {
            list = new ArrayList<>();
            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    list = dao.getAllFromItem();
                    usersAdapter = new usersAdapter(getActivity(), list);
                    fragmentUsersRv.setAdapter(usersAdapter);
                }
            });
        } catch (Exception e) {
        }

/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<item> list = dao.getAllFromItem();
                usersAdapter = new usersAdapter(getActivity(), list);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fragmentUsersRv.setAdapter(usersAdapter);
                    }
                });

            }
        }).start();
*/

    }


    @Override
    public void onStart() {
        intialFragment();
        super.onStart();
    }

    @Override
    public void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }

    @Override
    public void BackPressed() {
        super.BackPressed();
    }

    @OnClick(R.id.fragment_users_fbt_add_user)
    public void onViewClicked() {
        replaceFragment(getActivity().getSupportFragmentManager(), R.id.activity_frame_layout, new addUserFragment());
    }
}
