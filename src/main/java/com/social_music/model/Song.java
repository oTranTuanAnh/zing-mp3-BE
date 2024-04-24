package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String img_url;
    private String song_url;
    private String author;
    private String singer;
    private String album;
    @ManyToOne
    private SongTypes songTypes;
    @ManyToOne
    private AppUser appUser;
    private long listen_count;
}
