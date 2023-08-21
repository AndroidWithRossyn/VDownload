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
import com.videostream.wallpaperdiscover.fasttoolsdownload.activity.LiveWallActivity;

public class PlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);
        AppManage.getInstance(PlanetActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(PlanetActivity.this).showNativeBanner((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], "");
    }
    public void launchIntent(View v) {
        AppManage.getInstance(PlanetActivity.this).showInterstitialAd(PlanetActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
                intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(PlanetActivity.this, PlanetPaperWallpaperService.class));
                startActivity(intent);
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

    }

    public void launchSettingsIntent(View view) {
        AppManage.getInstance(PlanetActivity.this).showInterstitialAd(PlanetActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                Intent intent = new Intent(PlanetActivity.this, PlanetWallpaperSettingsActivity.class);
                startActivity(intent);
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

    }
    @Override
    public void onBackPressed() {
        AppManage.getInstance(PlanetActivity.this).showInterstitialAd(PlanetActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                PlanetActivity.super.onBackPressed();
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);
    }
}