package com.social_music.controller;


import com.social_music.model.SongTypes;
import com.social_music.service.impl.SongTypesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/songTypes")
public class SongTypesController {
    @Autowired
    private SongTypesServiceImpl songTypesService;
    @GetMapping
    public ResponseEntity<Iterable<SongTypes>> findAll() {
        return new ResponseEntity<>(songTypesService.findAll(), HttpStatus.OK);
    }
}
