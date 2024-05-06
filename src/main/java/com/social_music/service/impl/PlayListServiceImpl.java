package com.social_music.service.impl;

import com.social_music.model.PlayList;
import com.social_music.repository.PLayListRepo;
import com.social_music.service.IPlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayListServiceImpl implements IPlayListService {
    @Autowired
    private PLayListRepo playListRepo;

    @Override
    public Iterable<PlayList> findAll() {
        return playListRepo.findAll();
    }

    @Override
    public Optional<PlayList> findById(Long id) {
        return playListRepo.findById(id);
    }

    @Override
    public PlayList save(PlayList playList) {
        return playListRepo.save(playList);
    }

    @Override
    public void remove(Long id) {
        playListRepo.deleteById(id);
    }

    @Override
    public Iterable<PlayList> getAllByUserId(Long userId) {
        return playListRepo.findByAppUserId(userId);
    }
}
