package com.social_music.service;

import com.social_music.model.Song;

public interface ISongService extends GeneralService<Song> {
    Iterable<Song> getSongByUserId(Long userId);
}
