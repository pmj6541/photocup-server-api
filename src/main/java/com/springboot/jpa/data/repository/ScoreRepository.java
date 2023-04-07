package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
