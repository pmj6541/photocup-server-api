package com.springboot.jpa.data.repository;

import com.springboot.jpa.data.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
