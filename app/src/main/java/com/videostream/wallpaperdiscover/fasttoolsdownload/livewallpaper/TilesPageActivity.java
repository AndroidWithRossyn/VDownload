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
import com.videostream.wallpaperdiscover.fasttoolsdownload.activity.ThankuActivity;

public class TilesPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiles_page);
        AppManage.getInstance(TilesPageActivity.this).loadInterstitialAd(this);
        AppManage.getInstance(TilesPageActivity.this).showNativeBanner((ViewGroup) findViewById(R.id.native_ads), ADMOB_N[0], "");
    }
    public void launchIntent4(View v) {
        AppManage.getInstance(TilesPageActivity.this).showInterstitialAd(TilesPageActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                Intent intent = new Intent(WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
                intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT, new ComponentName(TilesPageActivity.this, ColloredWallpaperService.class));
                startActivity(intent);
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

    }

    public void launchSettingsIntent4(View view) {
        AppManage.getInstance(TilesPageActivity.this).showInterstitialAd(TilesPageActivity.this, new AppManage.MyCallback() {
            public void callbackCall() {
                Intent intent = new Intent(TilesPageActivity.this, TileWallpaperForwardMainActivity.class);
                startActivity(intent);
            }
        }, AppManage.ADMOB, AppManage.app_mainClickCntSwAd);

    }
}