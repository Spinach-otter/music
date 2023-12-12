package com.example.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backend.pojo.songList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SongListMapper extends BaseMapper<songList> {
}
