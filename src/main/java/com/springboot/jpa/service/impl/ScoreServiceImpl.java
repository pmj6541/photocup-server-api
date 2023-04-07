package com.springboot.jpa.service.impl;

import com.springboot.jpa.data.dao.ScoreDAO;
import com.springboot.jpa.data.dto.ScoreDto;
import com.springboot.jpa.data.dto.ScoreResponseDto;
import com.springboot.jpa.data.entity.Score;
import com.springboot.jpa.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScoreServiceImpl implements ScoreService {
    private final ScoreDAO scoreDAO;

    @Autowired
    public ScoreServiceImpl(ScoreDAO scoreDAO) {
        this.scoreDAO = scoreDAO;
    }


    @Override
    public ScoreResponseDto saveScore(ScoreDto scoreDto) {
        Score score = new Score();
        score.setPid(scoreDto.getPid());
        score.setUid(scoreDto.getUid());
        score.setRating(scoreDto.getRating());

        Score savedScore = scoreDAO.insertScore(score);

        ScoreResponseDto scoreResponseDto = new ScoreResponseDto();
        scoreResponseDto.setSid(savedScore.getSid());
        scoreResponseDto.setPid(savedScore.getPid());
        scoreResponseDto.setUid(savedScore.getUid());
        scoreResponseDto.setRating(savedScore.getRating());

        return scoreResponseDto;
    }

//    @Override
//    public ScoreResponseDto changeScore(Long sid, Double rating) throws Exception {
//
//        Score changedScore = scoreDAO.updateScore(sid, rating);
//
//        ScoreResponseDto scoreResponseDto = new ScoreResponseDto();
//        scoreResponseDto.setSid(changedScore.getSid());
//        scoreResponseDto.setPid(changedScore.getPid());
//        scoreResponseDto.setUid(changedScore.getUid());
//        scoreResponseDto.setRating(changedScore.getRating());
//
//        return scoreResponseDto;
//    }
}
