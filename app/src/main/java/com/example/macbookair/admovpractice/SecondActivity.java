package com.example.macbookair.admovpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class SecondActivity extends AppCompatActivity {


    private String TAG = SecondActivity.class.getSimpleName();
    InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        mInterstitialAd = new InterstitialAd(this);

        mInterstitialAd.setAdUnitId(getString(R.string.interstisial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded(){
                showInterstitial();
            }
        });

    }

    private void showInterstitial() {
        if(mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }
    }

}
