package com.example.albums.controllers;

import com.example.albums.dto.AlbumPostDto;
import com.example.albums.dto.AlbumPutDto;
import com.example.albums.entities.Album;
import com.example.albums.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;

    @PostMapping
    public ResponseEntity<Album> save(@RequestBody @Valid AlbumPostDto albumPostDto) {
        return new ResponseEntity<>(albumService.save(albumPostDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Album> findById(@PathVariable long id) {
        return ResponseEntity.ok(albumService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<Album>> list(Pageable pageable) {
        return ResponseEntity.ok(albumService.listAll(pageable));
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody AlbumPutDto albumPutDto) {
        albumService.replace(albumPutDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        albumService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
