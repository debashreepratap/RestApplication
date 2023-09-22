package com.test.restfulwebservices.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@AllArgsConstructor
@Setter
@Getter
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String errorMessage;
    private String errorDetails;
}
