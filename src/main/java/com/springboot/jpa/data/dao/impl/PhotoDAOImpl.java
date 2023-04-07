package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.PhotoDAO;
import com.springboot.jpa.data.entity.Photo;

import com.springboot.jpa.data.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
public class PhotoDAOImpl implements PhotoDAO {

    private final EntityManager em;

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoDAOImpl(EntityManager em, PhotoRepository photoRepository) {
        this.em = em;
        this.photoRepository = photoRepository;
    }

    @Override
    public Photo insertPhoto(Photo photo) {
        Photo savedPhoto = photoRepository.save(photo);

        return savedPhoto;
    }

    @Override
    public Photo selectPhoto(Long pid) {
        Photo selectedPhoto = photoRepository.getReferenceById(pid);

        return selectedPhoto;
    }

    @Override
    public List<Photo> selectLabel(String label) {
        List<Photo> selectedLabel = em.createQuery("select m from Photo m where m.label = :label", Photo.class)
                .setParameter("label", label)
                .getResultList();

        selectedLabel.sort(new Comparator<Photo>() {
            @Override
            public int compare(Photo o1, Photo o2) {

                if(o1.getScore() == o2.getScore()){
                    return Double.compare(o2.getCnt(), o1.getCnt());
                }

                return Double.compare(o2.getScore(), o1.getScore());
            }
        });

        if(selectedLabel.size() > 3) {
            return new ArrayList<>(selectedLabel.subList(0, 3));
        }

        return selectedLabel;
    }

//    @Override
//    public Optional<Photo> selectScore(Long pid){
//        Optional<Photo> selectedPhoto = Optional.ofNullable(photoRepository.getReferenceById(pid));
//
//        Double score = selectedPhoto.get().getScore();
//
//        List<Photo> result = em.createQuery("select m from Photo m where m.score = :score", Photo.class)
//                .setParameter("score", score)
//                .getResultList();
//
//        return result.stream().findAny();
//    }

    @Override
    public Photo updateScore(Long pid, Double sumScore, int cnt) throws Exception {
        Optional<Photo> selectedPhoto = Optional.ofNullable(photoRepository.getReferenceById(pid));

        Photo updatedPhoto;
        if(selectedPhoto.isPresent()) {
            Photo photo = selectedPhoto.get();

            photo.setCnt(++cnt);
            photo.setSumScore(photo.getSumScore() + Math.round(sumScore*100)/100.0);
            photo.setScore(Math.round(photo.getSumScore()/(double)photo.getCnt()*100)/100.0);

            updatedPhoto = photoRepository.save(photo);
        } else {
            throw new Exception();
        }

        return updatedPhoto;
    }

    @Override
    public void deletePhoto(Long pid) throws Exception {
        Optional<Photo> selectPhoto = Optional.ofNullable(photoRepository.getReferenceById(pid));

        if(selectPhoto.isPresent()) {
            Photo photo = selectPhoto.get();

            photoRepository.delete(photo);
        } else {
            throw new Exception();
        }
    }
}
