package com.example.albums.mappers;

import com.example.albums.dto.AlbumPostDto;
import com.example.albums.dto.AlbumPutDto;
import com.example.albums.entities.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AlbumMapper {
    Album albumPostDtoToAlbum(AlbumPostDto albumPostDto);

    Album albumPutDtoToAlbum(AlbumPutDto albumPutDto);
}
