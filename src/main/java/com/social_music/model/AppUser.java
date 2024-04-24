package com.social_music.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String oldPassword;
    private String confirmPassword;
    private String phoneNumber;
    private String avatar;
    private String address;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;

}
