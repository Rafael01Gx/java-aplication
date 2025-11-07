package br.com.alura.screenmatch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SerieException.class)
    public ResponseEntity<ResponseError> handleSerieException(SerieException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError(ex));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseError(ex));
    }

    private ResponseError responseError (Exception ex) {
        return new ResponseError(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now()
        );
    }
}
