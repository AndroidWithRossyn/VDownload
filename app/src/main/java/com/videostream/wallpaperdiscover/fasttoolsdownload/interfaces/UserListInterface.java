package com.videostream.wallpaperdiscover.fasttoolsdownload.interfaces;


import com.videostream.wallpaperdiscover.fasttoolsdownload.model.FBStoryModel.NodeModel;
import com.videostream.wallpaperdiscover.fasttoolsdownload.model.story.TrayModel;

public interface UserListInterface {
    void userListClick(int position, TrayModel trayModel);
    void fbUserListClick(int position, NodeModel trayModel);
}
