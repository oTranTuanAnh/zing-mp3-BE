package com.social_music.service.impl;

import com.social_music.model.AppUser;
import com.social_music.model.Comment;
import com.social_music.model.Likes;
import com.social_music.model.Song;
import com.social_music.repository.AppUserRepository;
import com.social_music.repository.CommentRepository;
import com.social_music.repository.SongRepo;
import com.social_music.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private SongRepo songRepository;
    @Autowired
    private AppUserRepository userRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public Iterable<Comment> findCommentBySongId(Long id) {
        return commentRepository.findCommentBySongId(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
    public Comment saveOrUpdate(Comment comment, Long uid, Long sid) {
        Song song = songRepository.findSongById(sid);
        AppUser user = userRepository.findAppUserById(uid);
            comment.setSong(song);
            comment.setUser(user);
            commentRepository.save(comment);
        return comment;
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}
