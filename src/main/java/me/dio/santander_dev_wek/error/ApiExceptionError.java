package me.dio.santander_dev_wek.error;


import me.dio.santander_dev_wek.dto.DefaultErrorDTO;
import me.dio.santander_dev_wek.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ApiExceptionError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entidadeNotFoundException(EntityNotFoundException e, WebRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        DefaultErrorDTO body = DefaultErrorDTO.builder().timestamp(LocalDateTime.now()).status(status).message(e.getMessage()).build();
        return handleExceptionInternal(e, body, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<?> throwableNotFoundException(Throwable e, WebRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        var msg = "Error inesperado!";
        DefaultErrorDTO body = DefaultErrorDTO.builder().timestamp(LocalDateTime.now()).status(status).message(msg).build();
        return handleExceptionInternal((Exception) e, body, new HttpHeaders(), status, request);
    }
}

