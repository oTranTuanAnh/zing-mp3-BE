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

    @PutMapping("/count/{id}")
    public ResponseEntity<?> countListen(@PathVariable Long id) {
        Optional<Song> songOptional = songService.findById(id);
        Song song = songOptional.get();
        song.setListenCount(song.getListenCount() + 1);
        return new ResponseEntity<>(songService.save(song),HttpStatus.OK);
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

    @GetMapping("findSongByTitle/{title}")
    public ResponseEntity<Iterable<Song>> findSongByTitle(@PathVariable String title) {
        return new ResponseEntity<>(songService.getSongByTitle(title), HttpStatus.OK);
    }

    @GetMapping("findSongByAuthor/{author}")
    public ResponseEntity<Iterable<Song>> findSongByAuthor(@PathVariable String author) {
        return new ResponseEntity<>(songService.getSongByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("findSongBySinger/{singer}")
    public ResponseEntity<Iterable<Song>> findSongBySinger(@PathVariable String singer) {
        return new ResponseEntity<>(songService.getSongBySinger(singer), HttpStatus.OK);
    }
    @GetMapping("newSongsList")
    public ResponseEntity<Iterable<Song>> newSongsList() {
        return new ResponseEntity<>(songService.getNewSongsList(),HttpStatus.OK);
    }

    @GetMapping("hotSongsList")
    public ResponseEntity<Iterable<Song>> hotSongsList() {
        return new ResponseEntity<>(songService.getHotSongsList(),HttpStatus.OK);
    }
    @GetMapping("favoriteSongs")
    public ResponseEntity<Iterable<Song>> favoriteSongs() {
        return new ResponseEntity<>(songService.getFavoriteSongs(),HttpStatus.OK);
    }
}