package com.social_music.service.impl;


import com.social_music.model.SongTypes;
import com.social_music.repository.SongTypesRepo;
import com.social_music.service.ISongTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongTypesServiceImpl implements ISongTypesService {
    @Autowired
    private SongTypesRepo songTypesRepo;

    @Override
    public Iterable<SongTypes> findAll() {
        return songTypesRepo.findAll();
    }

    @Override
    public Optional<SongTypes> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public SongTypes save(SongTypes songTypes) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }


}
