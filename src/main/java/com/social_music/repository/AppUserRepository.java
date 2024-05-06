package com.social_music.repository;
import com.social_music.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
    AppUser findAppUserById(Long id);

    Page<AppUser> findAll(Pageable pageable);
}