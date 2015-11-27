package com.nhc.nhcmaterialrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @OnClick(R.id.button1)
    void onClickBasicRecyclerView() {
        startAnActivity(BasicRecyclerViewActivity.class);
    }

    @OnClick(R.id.button2)
    void onClickAnimationRecyclerView() {
        startAnActivity(AnimationRecyclerViewActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void startAnActivity(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
