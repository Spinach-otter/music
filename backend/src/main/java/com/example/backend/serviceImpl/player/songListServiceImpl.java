package com.example.backend.serviceImpl.player;

import com.example.backend.mapper.SongListMapper;
import com.example.backend.pojo.songList;
import com.example.backend.service.player.songListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class songListServiceImpl implements songListService {
    @Autowired
    private SongListMapper songListMapper;
    @Override
    public List<songList> getsongList() {
        return songListMapper.selectList(null);
    }

    @Override
    public Map<String, String> getsong(Integer i) {
        List<songList> ListOfSong= getsongList();
        Map<String,String> res= new HashMap<>();
        res.put("songName",ListOfSong.get(i).getSongName());
        res.put("path",ListOfSong.get(i).getPath());
        res.put("photo",ListOfSong.get(i).getPhoto());
        return res;
    }
}
