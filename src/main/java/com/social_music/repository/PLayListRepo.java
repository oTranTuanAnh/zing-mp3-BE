package com.social_music.repository;

import com.social_music.model.PlayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PLayListRepo extends CrudRepository<PlayList, Long> {
}
