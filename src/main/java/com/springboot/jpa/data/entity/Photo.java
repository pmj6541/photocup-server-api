package com.springboot.jpa.data.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "photo")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    @Column(nullable = false)
    private String uid;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private String path;

    private Double score = 0.0;

    private Double sumScore = 0.0;

    private int cnt = 0;

    private LocalDateTime createdAt;

}
