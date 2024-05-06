package com.social_music.service;

import com.social_music.model.Comment;

public interface ICommentService extends GeneralService<Comment>{
    Iterable<Comment> findCommentBySongId(Long id);
}
