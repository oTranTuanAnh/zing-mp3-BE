package com.social_music.repository;

import com.social_music.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    Iterable<Comment> findCommentBySongId(Long id);
}
