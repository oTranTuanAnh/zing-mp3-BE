package com.social_music.controller;

import com.social_music.model.Song;
import com.social_music.service.impl.SongServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongServiceImpl songService;
    @GetMapping()
    public ResponseEntity<Iterable<Song>> findAll() {
        return new ResponseEntity<>(songService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Song>> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(songService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/user/create")
    public ResponseEntity<?> create(@RequestBody Song song) {
        return new ResponseEntity<>(songService.save(song),HttpStatus.CREATED);
    }

    @PutMapping("/user/update")
    public ResponseEntity<?> update(@RequestBody Song song) {
        return new ResponseEntity<>(songService.save(song),HttpStatus.OK);
    }

    @GetMapping("/findUserSongs/{id}")
    public ResponseEntity<Iterable<Song>> findUserSong(@PathVariable Long id) {
        return new ResponseEntity<>(songService.getSongByUserId(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        songService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}