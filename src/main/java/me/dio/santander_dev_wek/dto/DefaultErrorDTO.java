package me.dio.santander_dev_wek.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Builder
public record DefaultErrorDTO(LocalDateTime timestamp, HttpStatus status, String message) {
}
