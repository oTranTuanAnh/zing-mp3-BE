package com.social_music.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String userName;
    private String name;
    private String avatar;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtResponse(Long id, String token, String userName, String name, String avatar, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.token = token;
        this.userName = userName;
        this.name = name;
        this.authorities = authorities;
        this.avatar = avatar;
    }
}
