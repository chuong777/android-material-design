package com.nhc.nhcmaterialanimation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.imageView)
    ImageView ivImage;

    @OnClick(R.id.button5)
    void onClickBtn5() {
        if (ivImage.getVisibility() == View.VISIBLE) {
            hideImage();
        }
        else {
            showImage();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void hideImage() {
        // get the center for the clipping circle
        int cx = ivImage.getWidth() / 2;
        int cy = ivImage.getHeight() / 2;
        // get the initial radius for the clipping circle
        int initialRadius = ivImage.getWidth();
        // create the animation (the final radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(ivImage, cx, cy, initialRadius, 0);
        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ivImage.setVisibility(View.INVISIBLE);
            }
        });
        // start the animation
        anim.setDuration(1000);
        anim.start();
    }

    private void showImage() {
        // get the center for the clipping circle
        int cx = ivImage.getWidth() / 2;
        int cy = ivImage.getHeight() / 2;
        // get the final radius for the clipping circle
        int finalRadius = Math.max(ivImage.getWidth(), ivImage.getHeight());
        // create the animator for this view (the start radius is zero)
        Animator anim = ViewAnimationUtils.createCircularReveal(ivImage, cx, cy, 0, finalRadius);
        // make the view visible and start the animation
        ivImage.setVisibility(View.VISIBLE);
        anim.setDuration(1000);
        anim.start();
    }
}
