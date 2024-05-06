package com.social_music.service.impl;

import com.social_music.model.AppUser;
import com.social_music.model.Likes;
import com.social_music.model.Song;
import com.social_music.repository.AppUserRepository;
import com.social_music.repository.LikeRepository;
import com.social_music.repository.SongRepo;
import com.social_music.service.ILikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService implements ILikeService {
    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private SongRepo songRepository;
    @Autowired
    private AppUserRepository userRepository;

    @Override
    public Iterable<Likes> findAll() {
        return likeRepository.findAll();
    }
    public Iterable<Likes> findAllBySongIdAndUserId(Long sid, Long uid) {
        return likeRepository.findAllBySongIdAndAppUserId(sid, uid);
    }
    public boolean checkLikeByUserId(Long uid, Long sid){
        return likeRepository.existsByAppUserIdAndSongId(uid, sid);
    }

    @Override
    public Optional<Likes> findById(Long id) {
        return likeRepository.findById(id);
    }


    @Override
    public Likes save(Likes likes) {
        return likeRepository.save(likes);
    }

    @Override
    public void remove(Long id) {
        likeRepository.deleteById(id);
    }
    public Likes saveOrUpdate(Long uid, Long sid) {
        Likes likes = new Likes();
        Song song = songRepository.findSongById(sid);
        AppUser user = userRepository.findAppUserById(uid);
        Likes likes1 = likeRepository.findLikesByAppUserIdAndSongId(uid, sid);

            if (likes1 == null){
                likes.setSong(song);
                likes.setAppUser(user);
                likes.setLikeStatus(true);
                song.setCountLike(song.getCountLike()+1);
                songRepository.save(song);
                likeRepository.save(likes);
            } else {
               likeRepository.deleteById(likes1.getId());
                song.setCountLike(song.getCountLike()>0? song.getCountLike()-1: 0);
                songRepository.save(song);
            }

        return likes1;
    }
}