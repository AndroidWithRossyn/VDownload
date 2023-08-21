package com.videostream.wallpaperdiscover.fasttoolsdownload.activity;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pesonal.adsdk.AppManage;
import com.videostream.wallpaperdiscover.fasttoolsdownload.R;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.ClockActivity;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.PlanetActivity;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.StartLiveWallpaperActivity;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.TilesPageActivity;

public class LiveWallActivity extends AppCompatActivity {
    ImageView imBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_wall);
        AppManage.getInstance(LiveWallActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(LiveWallActivity.this).showNative((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], "");
        imBack=findViewById(R.id.imBack);
        TextView planet= findViewById(R.id.planet);
        TextView clock= findViewById(R.id.clock);
        TextView live_photo= findViewById(R.id.live_photo);
        TextView tiles= findViewById(R.id.tiles);
        planet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveWallActivity.this).showInterstitialAd(LiveWallActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(LiveWallActivity.this, PlanetActivity.class);
                        startActivity(intent);
                    }
                }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

            }
        });
        imBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveWallActivity.this).showInterstitialAd(LiveWallActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        LiveWallActivity.super.onBackPressed();
                    }
                }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

            }
        });
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveWallActivity.this).showInterstitialAd(LiveWallActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(LiveWallActivity.this, ClockActivity.class);
                        startActivity(intent);
                    }
                }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

            }
        });
        live_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveWallActivity.this).showInterstitialAd(LiveWallActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(LiveWallActivity.this, StartLiveWallpaperActivity.class);
                        startActivity(intent);
                    }
                }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

            }
        });
        tiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppManage.getInstance(LiveWallActivity.this).showInterstitialAd(LiveWallActivity.this, new AppManage.MyCallback() {
                    public void callbackCall() {
                        Intent intent = new Intent(LiveWallActivity.this, TilesPageActivity.class);
                        startActivity(intent);
                    }
                }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

            }
        });
    }
    @Override
    public void onBackPressed() {
        AppManage.getInstance(LiveWallActivity.this).showInterstitialAd(LiveWallActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                LiveWallActivity.super.onBackPressed();
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);
    }
}