package com.nhc.nhcmaterialtransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SharedActivity1 extends Activity implements View.OnClickListener {
    @Bind(R.id.iv_apple)
    ImageView ivApple;
    @Bind(R.id.iv_microsoft)
    ImageView ivMicrosoft;
    @Bind(R.id.iv_amazon)
    ImageView ivAmazon;
    @Bind(R.id.iv_google)
    ImageView ivGoogle;
    public static Drawable image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setExitTransition(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared1);
        ButterKnife.bind(this);
        ivApple.setOnClickListener(this);
        ivAmazon.setOnClickListener(this);
        ivGoogle.setOnClickListener(this);
        ivMicrosoft.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        image = ((ImageView) v).getDrawable();
        int id = v.getId();
        switch (id) {
            case R.id.iv_amazon: break;
            case R.id.iv_apple: break;
            case R.id.iv_google: break;
            case R.id.iv_microsoft:break;
        }
        //v.setTransitionName("nhc");
        Intent intent = new Intent(this, SharedActivity2.class);
        intent.putExtra("id", id);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, v, "nhc");
        startActivity(intent, options.toBundle());
    }
}
