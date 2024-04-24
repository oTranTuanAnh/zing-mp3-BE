package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class SongTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}