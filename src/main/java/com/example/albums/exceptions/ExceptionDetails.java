package com.example.albums.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionDetails {
    private Date timestamp;
    private String message;
    private String details;
}
