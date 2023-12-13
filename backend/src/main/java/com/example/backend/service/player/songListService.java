package com.example.backend.service.player;

import com.example.backend.pojo.songList;

import java.util.List;
import java.util.Map;

public interface songListService {
    List<songList> getsongList();
    Map<String,String> getsong(Integer i);
    List<songList> searchSong(String filter);
}
