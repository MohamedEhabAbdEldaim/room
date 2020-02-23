package com.midooabdaim.room.ui.activity;

import android.os.Bundle;

import com.midooabdaim.room.R;
import com.midooabdaim.room.ui.fragment.usersFragment;

import java.util.concurrent.Executors;

import static com.midooabdaim.room.helper.HelperMethod.replaceFragment;


public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(getSupportFragmentManager(), R.id.activity_frame_layout, new usersFragment());
    }

    private void roomthread() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}
