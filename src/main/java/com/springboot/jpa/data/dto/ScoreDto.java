package com.springboot.jpa.data.dto;

import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ScoreDto {

    private Long pid;

    private String uid;

    private Double rating;
}
