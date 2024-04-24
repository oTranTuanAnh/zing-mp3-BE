package com.social_music.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrinciple implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String userName;
    private final String password;
    private final Collection<? extends GrantedAuthority> roles;
    public UserPrinciple(String userName, String password,
                         Collection<? extends GrantedAuthority> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
    public static UserPrinciple build(AppUser user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (AppRole role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new UserPrinciple(user.getUserName(),
                user.getPassword(),authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return userName;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}
