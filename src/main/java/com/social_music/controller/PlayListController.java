package com.social_music.controller;

import com.social_music.model.PlayList;
import com.social_music.model.Song;
import com.social_music.service.impl.PlayListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("playlists")
public class PlayListController {
    @Autowired
    private PlayListServiceImpl playListService;

    @GetMapping
    public ResponseEntity<Iterable<PlayList>> findAll() {
        return new ResponseEntity<>(playListService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody PlayList playList) {
        return new ResponseEntity<>(playListService.save(playList), HttpStatus.CREATED);
    }
}
