package com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.database;

import static com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.utils.Constant.DB_NAME;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.database.dao.PlaylistDao;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.database.dao.WallpaperDao;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.database.models.LocalWallpaper;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.database.models.Playlist;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {LocalWallpaper.class, Playlist.class}, version = 3, exportSchema = false)
public abstract class LiveWallpaperDatabase extends RoomDatabase {

    public abstract WallpaperDao wallpaperDao();
    public abstract PlaylistDao playlistDao();

    private static volatile LiveWallpaperDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static LiveWallpaperDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LiveWallpaperDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            LiveWallpaperDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
