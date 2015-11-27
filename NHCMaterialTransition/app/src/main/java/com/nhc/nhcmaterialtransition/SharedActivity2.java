package com.nhc.nhcmaterialtransition;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SharedActivity2 extends Activity {
    @Bind(R.id.ivImage)
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setEnterTransition(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared2);
        ButterKnife.bind(this);
        ivImage.setTransitionName("nhc");
        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        ivImage.setImageDrawable(SharedActivity1.image);
    }
}
