package com.springboot.jpa.controller;

import com.springboot.jpa.data.dto.PhotoDto;
import com.springboot.jpa.data.dto.PhotoResponseDto;
import com.springboot.jpa.data.entity.Photo;
import com.springboot.jpa.data.repository.PhotoRepository;
import com.springboot.jpa.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photo")
public class PhotoController {

    private final PhotoService photoService;

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoController(PhotoService photoService, PhotoRepository photoRepository) {
        this.photoService = photoService;
        this.photoRepository = photoRepository;
    }

    @GetMapping("/label")
    public ResponseEntity<List<Photo>> getLabel(String label){
        List<Photo> photoResponseDto = photoService.getLabel(label);

        return ResponseEntity.status(HttpStatus.OK).body(photoResponseDto);
    }

    @GetMapping("/score")
    public ResponseEntity<PhotoResponseDto> getScore(Long pid){
        PhotoResponseDto photoResponseDto = photoService.getPhoto(pid);

        return ResponseEntity.status(HttpStatus.OK).body(photoResponseDto);
    }

    @GetMapping()
    public ResponseEntity<PhotoResponseDto> getPhoto(Long pid){
        PhotoResponseDto photoResponseDto = photoService.getPhoto(pid);

        return ResponseEntity.status(HttpStatus.OK).body(photoResponseDto);
    }

    @PostMapping()
    public ResponseEntity<PhotoResponseDto> createPhoto(@RequestBody PhotoDto photoDto){
        PhotoResponseDto photoResponseDto = photoService.savePhoto(photoDto);

        return ResponseEntity.status(HttpStatus.OK).body(photoResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deletePhoto(Long pid) throws Exception{
        photoService.deletePhoto(pid);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
