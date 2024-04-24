package com.social_music.service.impl;

import com.social_music.model.AppRole;
import com.social_music.repository.AppRoleRepository;
import com.social_music.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleServiceImpl implements AppRoleService {
    @Autowired
    private AppRoleRepository appRoleRepository;

    @Override
    public Iterable<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public void save(AppRole appRole) {
        appRoleRepository.save(appRole);
    }

    @Override
    public AppRole findByName(String name) {
        return appRoleRepository.findByName(name);
    }


}
