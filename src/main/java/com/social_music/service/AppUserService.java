package com.social_music.service;


import com.social_music.model.AppUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface AppUserService extends UserDetailsService {
    AppUser save(AppUser appUser);

    Iterable<AppUser> findAll();

    AppUser findByUsername(String username);

    AppUser getCurrentUser();

    Optional<AppUser> findById(Long id);

    UserDetails loadUserById(Long id);
    public Page<AppUser> getAllUsers(Pageable pageable);
    boolean checkLogin(AppUser appUser);

    boolean isRegister(AppUser appUser);

    boolean isCorrectConfirmPassword(AppUser appUser);
}
