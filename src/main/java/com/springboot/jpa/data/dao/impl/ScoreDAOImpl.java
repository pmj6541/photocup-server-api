package com.springboot.jpa.data.dao.impl;

import com.springboot.jpa.data.dao.PhotoDAO;
import com.springboot.jpa.data.dao.ScoreDAO;
import com.springboot.jpa.data.entity.Photo;
import com.springboot.jpa.data.entity.Score;
import com.springboot.jpa.data.repository.PhotoRepository;
import com.springboot.jpa.data.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class ScoreDAOImpl implements ScoreDAO {

    private final EntityManager em;

    private final ScoreRepository scoreRepository;

    private final PhotoRepository photoRepository;

    private final PhotoDAO photoDAO;

    @Autowired
    public ScoreDAOImpl(EntityManager em, ScoreRepository scoreRepository, PhotoRepository photoRepository, PhotoDAO photoDAO) {
        this.em = em;
        this.scoreRepository = scoreRepository;
        this.photoRepository = photoRepository;
        this.photoDAO = photoDAO;
    }

    @Override
    public Score insertScore(Score score) {
        Score savedScore = scoreRepository.save(score);

        Optional<Photo> selectedPhoto = Optional.ofNullable(photoRepository.getReferenceById(savedScore.getPid()));

        if(selectedPhoto.isPresent()){
            try {
                Photo photo = photoDAO.updateScore(selectedPhoto.get().getPid(), savedScore.getRating(), selectedPhoto.get().getCnt());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return savedScore;
    }

//    @Override
//    public Optional<Score> selectScore(Long sid) {
//        List<Score> result = em.createQuery("select m from Member m where m.sid = :sid", Score.class)
//                .setParameter("sid", sid)
//                .getResultList();
//
//        return result.stream().findAny();
//    }

//    @Override
//    public Score updateScore(Long sid, Double rating) throws Exception{
//        Optional<Score> selectedScore = scoreRepository.findById(sid);
//
//        Score updatedScore;
//        if(selectedScore.isPresent()){
//            Score score = selectedScore.get();
//
//            score.setSid(sid);
//
//            updatedScore = scoreRepository.save(score);
//        } else {
//            throw new Exception();
//        }
//
//        return updatedScore;
//    }

}
