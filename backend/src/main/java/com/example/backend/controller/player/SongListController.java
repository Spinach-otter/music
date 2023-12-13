package com.example.backend.controller.player;

import com.example.backend.pojo.songList;
import com.example.backend.service.player.songListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SongListController {
    @Autowired
    private songListService songListService;

    @RequestMapping("/get/songlist/")
    public List<songList> getsongList() {
        return songListService.getsongList();
    }
    @RequestMapping("/search/songlist/")
    public List<songList> searchSong(@RequestParam Map<String,String> data) {
        return songListService.searchSong(data.get("filter"));
    }
    @RequestMapping("/get/song/")
    public Map<String,String> getSong(@RequestParam Map<String,String> data) {
        return songListService.getsong(Integer.valueOf(data.get("i")));
    }
}
