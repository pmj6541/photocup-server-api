package com.springboot.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PhotoResponseDto {

    private Long pid;

    private String uid;

    private String label;

    private String path;

    private Double score;

    private Double sumScore;

    private int cnt;
}
