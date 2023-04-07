package com.springboot.jpa.service;

import com.springboot.jpa.data.dto.PhotoDto;
import com.springboot.jpa.data.dto.PhotoResponseDto;
import com.springboot.jpa.data.entity.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhotoService {

    PhotoResponseDto getPhoto(Long pid);

    PhotoResponseDto savePhoto(PhotoDto photoDto);

    List<Photo> getLabel(String label);

    PhotoResponseDto getScore(Long pid);

    void deletePhoto(Long pid) throws Exception;
}
