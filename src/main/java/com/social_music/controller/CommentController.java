package com.social_music.controller;

import com.social_music.model.Comment;
import com.social_music.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Comment>> listComments(@PathVariable Long id) {
        return new ResponseEntity<>(commentService.findCommentBySongId(id), HttpStatus.OK);
    }


    @PostMapping("/create/{uid}/{sid}")
    public ResponseEntity<Comment> create(@RequestBody Comment comment, @PathVariable Long uid, @PathVariable Long sid){
        return new ResponseEntity<>(commentService.saveOrUpdate(comment, uid, sid), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Comment> delete(@PathVariable Long id) {
        Optional<Comment> comOptional = commentService.findById(id);
        if (!comOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        commentService.remove(id);
        return new ResponseEntity<>(comOptional.get(),HttpStatus.OK);
    }
}
