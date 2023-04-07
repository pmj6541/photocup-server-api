package com.springboot.jpa.data.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PhotoDto {
    private String uid;

    private String label;

    private String path;
}
