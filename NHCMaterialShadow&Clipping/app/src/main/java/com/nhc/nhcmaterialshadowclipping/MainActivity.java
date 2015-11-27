package com.nhc.nhcmaterialshadowclipping;

import android.graphics.Outline;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.tv_text)
    TextView tvText;
    @OnClick(R.id.tv_text)
    void onClickTvText() {
        tvText.animate().translationZ(25).withEndAction(new Runnable() {
            @Override
            public void run() {
                tvText.animate().translationZ(15);
            }
        });
    }
    @Bind(R.id.tv_text1)
    TextView tvText1;
    @OnClick(R.id.tv_text1)
    void onClickTvText1() {
        tvText1.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRect(0, 0, view.getWidth(), view.getHeight());
                view.setClipToOutline(true);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tvText.setElevation(10);
        tvText.setTranslationZ(15);
    }
}
