package com.dasanianand.adsbannerads;

import androidx.appcompat.app.AppCompatActivity;

import com.dasanianand.adsbannerads.Ads.BannerAdMainActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public AdView mAdView;
    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init UI
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

        imageView.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        textView.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        BannerAdMainActivity.show(mAdView, MainActivity.this);
    }
}
