package com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper;

import static com.pesonal.adsdk.AppManage.ADMOB_N;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.pesonal.adsdk.AppManage;
import com.videostream.wallpaperdiscover.fasttoolsdownload.R;
import com.videostream.wallpaperdiscover.fasttoolsdownload.SocialMediaPages.ChingariActivity;

public class ClockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        AppManage.getInstance(ClockActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(ClockActivity.this).showNativeBanner((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], "");

    }
    public void launchIntent1(View v) {
        AppManage.getInstance(ClockActivity.this).showInterstitialAd(ClockActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
                intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(ClockActivity.this, FractalClockWallpaperService.class));
                startActivity(intent);
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

    }

    public void launchSettingsIntent1(View view) {
        AppManage.getInstance(ClockActivity.this).showInterstitialAd(ClockActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                Intent intent = new Intent(ClockActivity.this, FractalClockPreferencesActivity.class);
                startActivity(intent);
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

    }

    @Override
    public void onBackPressed() {
        AppManage.getInstance(ClockActivity.this).showInterstitialAd(ClockActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                ClockActivity.super.onBackPressed();
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);
    }
}