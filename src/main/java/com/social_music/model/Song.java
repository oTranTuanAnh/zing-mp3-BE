package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String img_url;
    private String song_url;
    private String author;
    private String singer;
    private String album;
    @CreationTimestamp
    private Date date;
    private int countLike;
    private boolean likes;
    @ManyToOne
    private SongTypes songTypes;
    @ManyToOne
    private AppUser appUser;
    private Long listenCount = 0L;
}
