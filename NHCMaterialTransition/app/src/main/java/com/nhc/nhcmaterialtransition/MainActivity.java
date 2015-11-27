package com.nhc.nhcmaterialtransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {
    @OnClick(R.id.button)
    void startActivityWithTransition() {
        Intent intent = new Intent(this, Main2Activity.class);
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }
    @OnClick(R.id.button17)
    void startActivityWithoutTransition() {
        Intent intent = new Intent(this, SharedActivity1.class);
        startActivity(intent, null);
        //Or just startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
