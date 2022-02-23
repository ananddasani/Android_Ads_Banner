# Android_Ads_Banner
Integrating Banner Ad in an Application 

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

<img src="app_images/Ads Banner Code.png" width="1000" /><br>

<img src="app_images/Ads Banner App1.png" width="300" /><br>
