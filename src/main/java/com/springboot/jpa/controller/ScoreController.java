package com.springboot.jpa.controller;

import com.springboot.jpa.data.dto.ScoreDto;
import com.springboot.jpa.data.dto.ScoreResponseDto;
import com.springboot.jpa.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/score")
public class ScoreController {

    private final ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping()
    public ResponseEntity<ScoreResponseDto> createScore(@RequestBody ScoreDto scoreDto){
        ScoreResponseDto scoreResponseDto = scoreService.saveScore(scoreDto);

        return ResponseEntity.status(HttpStatus.OK).body(scoreResponseDto);
    }
}
