package com.springboot.jpa.data.dao;

import com.springboot.jpa.data.entity.Score;

import java.util.Optional;

public interface ScoreDAO {

    Score insertScore(Score score);

//    Optional<Score> selectScore(Long sid);

//    Score updateScore(Long sid, Double score) throws Exception;

}
