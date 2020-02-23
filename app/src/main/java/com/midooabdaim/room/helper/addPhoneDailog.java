package com.midooabdaim.room.helper;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.midooabdaim.room.R;


public class addPhoneDailog extends Dialog implements View.OnClickListener {

    private Activity activity;
    private Button add, cancle;

    public addPhoneDailog(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dailog_phone);
        setCancelable(false);
        setCanceledOnTouchOutside(true);
        // add = (Button) findViewById(R.id.btn_add);
        //cancle = (Button) findViewById(R.id.btn_cancle);
        add.setOnClickListener(this);
        cancle.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //  case R.id.btn_add:

            //   break;
            // R.id.btn_cancle:
            //    cancel();
            //    break;
            default:
                break;
        }
        dismiss();
    }
}
