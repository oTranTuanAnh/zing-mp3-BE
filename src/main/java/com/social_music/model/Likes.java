package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Song song;
    @ManyToOne
    private AppUser appUser;
    private boolean likeStatus;
}