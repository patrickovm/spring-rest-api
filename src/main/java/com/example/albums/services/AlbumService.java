package com.example.albums.services;

import com.example.albums.dto.AlbumPostDto;
import com.example.albums.dto.AlbumPutDto;
import com.example.albums.entities.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlbumService {
    Album save(AlbumPostDto albumPostDto);

    Album findById(Long id);

    Page<Album> listAll(Pageable pageable);

    void replace(AlbumPutDto albumPutDto);

    void delete(Long id);
}
