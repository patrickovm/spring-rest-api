package com.example.albums.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class AlbumPostDto {
    @NotEmpty(message = "The title field cannot be empty")
    private String title;

    @NotEmpty(message = "The artist field cannot be empty")
    private String artist;

    private Double price;
}
