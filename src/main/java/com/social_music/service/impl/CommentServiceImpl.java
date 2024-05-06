package com.social_music.service.impl;

import com.social_music.model.Comment;
import com.social_music.repository.CommentRepository;
import com.social_music.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentRepository commentRepository;

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

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}
