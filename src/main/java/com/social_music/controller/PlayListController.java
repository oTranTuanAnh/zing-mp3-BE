package com.social_music.controller;

import com.social_music.model.PlayList;
import com.social_music.model.Song;
import com.social_music.service.impl.PlayListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("{id}")
    public ResponseEntity<Optional<PlayList>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(playListService.findById(id),HttpStatus.OK);
    }

    @GetMapping("findByUserId/{id}")
    public ResponseEntity<Iterable<PlayList>> findAllByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(playListService.getAllByUserId(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody PlayList playList) {
        return new ResponseEntity<>(playListService.save(playList),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        playListService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
