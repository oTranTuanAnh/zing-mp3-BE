package com.social_music.repository;




import com.social_music.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByName(String roleName);
    AppRole findOneByName(String name);
    Set<AppRole> findAllByIdIn(List<Long> ids);
}