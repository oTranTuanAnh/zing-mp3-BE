package com.social_music.service;


import com.social_music.model.AppRole;

public interface AppRoleService {
    Iterable<AppRole> findAll();

    void save(AppRole appRole);

    AppRole findByName(String name);
}
