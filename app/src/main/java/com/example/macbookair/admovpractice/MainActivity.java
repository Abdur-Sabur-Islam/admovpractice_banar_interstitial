package com.example.macbookair.admovpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import static com.example.macbookair.admovpractice.R.id.full_Screen_Btn;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    private Button btnFullscreenAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        btnFullscreenAd = (Button) findViewById(R.id.full_Screen_Btn);

        btnFullscreenAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

    }

    @Override
    public void onPause(){
        if(mAdView != null){
            mAdView.pause();
        }
        super.onPause();

    }

    public void onResume(){
        super.onResume();

        if(mAdView != null){
            mAdView.resume();
        }

    }

    public  void onDestroy(){
        if(mAdView !=null){
            mAdView.resume();
        }
        super.onDestroy();
    }

}
