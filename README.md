# Android_Ads_Banner
Integrating Banner Ad in an Application 

This topic is a part of [My Complete Andorid Course](https://github.com/ananddasani/Android_Apps)

# Code

#### MainActivity.java
```
public AdView mAdView;
TextView textView;
ImageView imageView;

      //Init Ads
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
```

#### BannerAdMainActivity.java (I have Implemented Ads Listeners in This Class)
```
public class BannerAdMainActivity {

    public static void show(AdView mAdView, Context context){

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);

                //No need to explicitly do ad request
                //mAdView.loadAd(adRequest);

            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                Toast.makeText(context, "Ads Loaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();

                Toast.makeText(context, "Ad Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();

                Toast.makeText(context, "OnAdImpression", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
```

# App Highlight

![Ads Banner App1](https://user-images.githubusercontent.com/74413402/192094269-ce8347d8-303c-4bc7-961c-b9091f32391b.png)
![Ads Banner Code](https://user-images.githubusercontent.com/74413402/192094271-5174ffaf-0c68-4729-a48f-4bf769b41f88.png)

