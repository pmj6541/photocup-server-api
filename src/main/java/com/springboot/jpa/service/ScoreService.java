package com.springboot.jpa.service;

import com.springboot.jpa.data.dto.ScoreDto;
import com.springboot.jpa.data.dto.ScoreResponseDto;

public interface ScoreService {

    ScoreResponseDto saveScore(ScoreDto scoreDto);

//    ScoreResponseDto changeScore(Long sid, Double rating) throws Exception;
}
