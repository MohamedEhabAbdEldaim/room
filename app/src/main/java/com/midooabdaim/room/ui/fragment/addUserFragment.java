package com.midooabdaim.room.ui.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.midooabdaim.room.R;
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
import static com.midooabdaim.room.helper.HelperMethod.cleanError;
import static com.midooabdaim.room.helper.HelperMethod.disappearKeypad;

/**
 * A simple {@link Fragment} subclass.
 */
public class addUserFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.fragment_add_user_til_name)
    TextInputLayout fragmentAddUserTilName;
    @BindView(R.id.fragment_add_user_til_pass)
    TextInputLayout fragmentAddUserTilPass;
    @BindView(R.id.fragment_add_user_til_age)
    TextInputLayout fragmentAddUserTilAge;
    private DaoAccess dao;
    private item item;
    private List<item> list = new ArrayList<>();
    private List<TextInputLayout> textInputLayouts = new ArrayList<>();


    public addUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        intialFragment();
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);
        unbinder = ButterKnife.bind(this, view);
        dao = getInstance(getActivity()).daoAccess();
        textInputLayouts.add(fragmentAddUserTilName);
        textInputLayouts.add(fragmentAddUserTilPass);
        textInputLayouts.add(fragmentAddUserTilAge);
        return view;
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

    @OnClick({R.id.fragment_add_user_btn_add})
    public void onViewClicked(View view) {
        disappearKeypad(getActivity(), view);
        switch (view.getId()) {
            case R.id.fragment_add_user_btn_add:
                add();
                break;
        }
    }
    private void add() {
        try {
            cleanError(textInputLayouts);
            String name = fragmentAddUserTilName.getEditText().getText().toString();
            String pass = fragmentAddUserTilPass.getEditText().getText().toString();
            if (name.equals("")) {
                fragmentAddUserTilName.setError("you must insert name");
                return;
            }
            if (pass.equals("")) {
                fragmentAddUserTilPass.setError("you must insert pass");
                return;
            }
            if (fragmentAddUserTilAge.getEditText().getText().toString().equals("")) {
                fragmentAddUserTilAge.setError("you must insert age");
                return;
            }
            int age = Integer.valueOf(fragmentAddUserTilAge.getEditText().getText().toString());
            if (!(0 < age && age < 150)) {
                fragmentAddUserTilAge.setError("you must insert real age");
                return;
            }


            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    item = new item(name, pass, age);
                    dao.addToItem(item);
                }
            });

            Toast.makeText(getActivity(), "added", Toast.LENGTH_LONG).show();


        } catch (Exception e) {
            Log.i("midoo", "add: " + e);
        }

    }

}
