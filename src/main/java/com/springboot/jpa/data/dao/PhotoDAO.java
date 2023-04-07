package com.springboot.jpa.data.dao;

import com.springboot.jpa.data.entity.Photo;
import com.springboot.jpa.data.entity.Score;

import java.util.List;
import java.util.Optional;

public interface PhotoDAO {

    Photo insertPhoto(Photo photo);

    Photo selectPhoto(Long pid);

    List<Photo> selectLabel(String label);

//    Optional<Photo> selectScore(Long pid);

    Photo updateScore(Long pid, Double sumScore, int cnt) throws Exception;

    void deletePhoto(Long pid) throws Exception; //안씀

}
