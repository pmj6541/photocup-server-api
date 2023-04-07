package com.springboot.jpa.service.impl;

import com.springboot.jpa.data.dao.PhotoDAO;
import com.springboot.jpa.data.dto.PhotoDto;
import com.springboot.jpa.data.dto.PhotoResponseDto;
import com.springboot.jpa.data.entity.Photo;
import com.springboot.jpa.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PhotoServiceImpl implements PhotoService {

    private final PhotoDAO photoDAO;

    @Autowired
    public PhotoServiceImpl(PhotoDAO photoDAO){
        this.photoDAO = photoDAO;
    }

    @Override
    public PhotoResponseDto getPhoto(Long pid){
        Photo photo = photoDAO.selectPhoto(pid);

        PhotoResponseDto photoResponseDto = new PhotoResponseDto();
        photoResponseDto.setPid(photo.getPid());
        photoResponseDto.setUid(photo.getUid());
        photoResponseDto.setLabel(photo.getLabel());
        photoResponseDto.setPath(photo.getPath());
        photoResponseDto.setScore(photo.getScore());

        return photoResponseDto;
    }

    @Override
    public PhotoResponseDto savePhoto(PhotoDto photoDto) {
        Photo photo = new Photo();
        photo.setUid(photoDto.getUid());
        photo.setLabel(photoDto.getLabel());
        photo.setPath(photoDto.getPath());
        photo.setCreatedAt(LocalDateTime.now());

        Photo savedPhoto = photoDAO.insertPhoto(photo);

        PhotoResponseDto photoResponseDto = new PhotoResponseDto();
        photoResponseDto.setPid(savedPhoto.getPid());
        photoResponseDto.setUid(savedPhoto.getUid());
        photoResponseDto.setLabel(savedPhoto.getLabel());
        photoResponseDto.setPath(savedPhoto.getPath());
        photoResponseDto.setSumScore(savedPhoto.getSumScore());
        photoResponseDto.setCnt(savedPhoto.getCnt());
        photoResponseDto.setScore(savedPhoto.getScore());

        return photoResponseDto;
    }

    @Override
    public List<Photo> getLabel(String label) {
        List<Photo> photo = photoDAO.selectLabel(label);

        return photo;
    }

    @Override
    public PhotoResponseDto getScore(Long pid) {
        Photo photo = photoDAO.selectPhoto(pid);

        PhotoResponseDto photoResponseDto = new PhotoResponseDto();
        photoResponseDto.setPid(photo.getPid());
        photoResponseDto.setScore(photo.getScore());

        return photoResponseDto;
    }

    @Override
    public void deletePhoto(Long pid) throws Exception {
        photoDAO.deletePhoto(pid);
    }
}
