package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.pojo.songList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SongListMapper extends BaseMapper<songList> {
    List<songList> findSong(String filter);
}
