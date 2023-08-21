package com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.database.models.Playlist;
import com.videostream.wallpaperdiscover.fasttoolsdownload.livewallpaper.database.repository.PlaylistRepository;

import java.util.List;

public class PlaylistViewModel extends AndroidViewModel {

    private PlaylistRepository mRepository;
    private LiveData<List<Playlist>> allPlaylists;


    public PlaylistViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = new PlaylistRepository(application);
        this.allPlaylists = mRepository.getAllPlaylists();
    }

    public LiveData<List<Playlist>> getAllPlaylists() {
        return allPlaylists;
    }

    public void insert(Playlist playlist) {
        mRepository.insert(playlist);
    }

    public void delete(Playlist playlist) {
        mRepository.delete(playlist);
    }

    public void update(Playlist playlist) {
        mRepository.update(playlist);
    }
}
