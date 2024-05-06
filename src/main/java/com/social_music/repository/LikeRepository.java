package com.social_music.repository;


import com.social_music.model.Likes;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface LikeRepository extends CrudRepository<Likes, Long> {
    Iterable<Likes> findAllBySongIdAndAppUserId (Long sid, Long uid);
    Iterable<Likes> findAllByAppUserId (Long uid);
    Likes findLikesByAppUserIdAndSongId(Long uid, Long sid);
    Boolean existsByAppUserIdAndSongId(Long uid, Long sid);
}
