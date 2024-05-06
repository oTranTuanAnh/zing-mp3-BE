package com.social_music.service;

import com.social_music.model.Song;

public interface ISongService extends GeneralService<Song> {
    Iterable<Song> getSongByUserId(Long userId);

    Iterable<Song> getSongByTitle(String title);

    Iterable<Song> getSongByAuthor(String authorName);

    Iterable<Song> getSongBySinger(String singer);

    Iterable<Song> getNewSongsList();

    Iterable<Song> getHotSongsList();

    Iterable<Song> getFavoriteSongs();
}
