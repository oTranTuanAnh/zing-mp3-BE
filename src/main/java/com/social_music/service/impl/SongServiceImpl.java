package com.social_music.service.impl;

import com.social_music.model.Song;
import com.social_music.repository.SongRepo;
import com.social_music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class SongServiceImpl implements ISongService {
    @Autowired
    private SongRepo songRepo;

    @Override
    public Iterable<Song> findAll() {
        return songRepo.findAll();
    }
    @Override
    public Optional<Song> findById(Long id) {
        return songRepo.findById(id);
    }
    @Override
    public Song save(Song song) {
        return songRepo.save(song);
    }

    @Override
    public void remove(Long id) {
        songRepo.deleteById(id);
    }

    @Override
    public Iterable<Song> getSongByUserId(Long userId) {
        return songRepo.findSongByAppUserId(userId);
    }

    @Override
    public Iterable<Song> getSongByTitle(String title) {
        return songRepo.findSongByTitleContaining(title);
    }

    @Override
    public Iterable<Song> getSongByAuthor(String authorName) {
        return songRepo.findSongByAuthorContaining(authorName);
    }

    @Override
    public Iterable<Song> getSongBySinger(String singer) {
        return songRepo.findSongBySingerContaining(singer);
    }

    @Override
    public Iterable<Song> getNewSongsList() {
        return songRepo.findAllByOrderByDateDesc();
    }

}
