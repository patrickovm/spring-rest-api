package com.example.albums.services;

import com.example.albums.dto.AlbumPostDto;
import com.example.albums.dto.AlbumPutDto;
import com.example.albums.entities.Album;
import com.example.albums.exceptions.ResourceNotFoundException;
import com.example.albums.mappers.AlbumMapper;
import com.example.albums.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;

    @Override
    @Transactional
    public Album save(AlbumPostDto albumPostDto) {
        return albumRepository.save(albumMapper.albumPostDtoToAlbum(albumPostDto));
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Album not Found"));
    }

    @Override
    public Page<Album> listAll(Pageable pageable) {
        return albumRepository.findAll(pageable);
    }

    @Override
    public void replace(AlbumPutDto albumPutDto) {
        Album savedAlbum = findById(albumPutDto.getId());
        Album album = albumMapper.albumPutDtoToAlbum(albumPutDto);
        album.setId(savedAlbum.getId());
        albumRepository.save(album);
    }

    @Override
    public void delete(Long id) {
        albumRepository.delete(findById(id));
    }
}
