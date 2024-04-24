package com.social_music.repository;

import com.social_music.model.AppUser;
import com.social_music.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends CrudRepository<Song, Long> {
    Iterable<Song> findSongByAppUserId(Long appUser_id);
}
