package com.social_music.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;


@Entity
@Table
@Data
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private AppUser appUser;
    private String name;
}
