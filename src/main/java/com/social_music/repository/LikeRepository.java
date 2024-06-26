package com.social_music.repository;

import com.social_music.model.AppUser;
import com.social_music.model.Likes;
import com.social_music.model.Song;
import com.social_music.model.dto.GetSongLikeByUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
    @Query(nativeQuery = true, value = "select  song_id as sid from likes where app_user_id = :id;")
    Iterable<GetSongLikeByUser> findAllSongLikeByUser(@Param("id")Long id);
    void deleteBySongId(Long id);
}
