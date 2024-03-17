package com.developers.ipasrilankaapi.advisers;

import com.developers.ipasrilankaapi.exception.*;
import com.developers.ipasrilankaapi.exception.NullPointerException;
import com.developers.ipasrilankaapi.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<StandardResponse> handleUserNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, e.getMessage(), e),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<StandardResponse> handleUserLockedException(LockedException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(423, e.getMessage(), e),
                HttpStatus.LOCKED);
    }

    @ExceptionHandler(AccountStatusException.class)
    public ResponseEntity<StandardResponse> handleUserNotVerifiedException(AccountStatusException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(503, e.getMessage(), e),
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(UserNotAcceptableException.class)
    public ResponseEntity<StandardResponse> handleUserNotAcceptableException(UserNotAcceptableException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(406, e.getMessage(), e),
                HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<StandardResponse> handleUserRestrictedException(MethodNotAllowedException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(405, e.getMessage(), e),
                HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(PaymentRequiredException.class)
    public ResponseEntity<StandardResponse> handlePaymentException(PaymentRequiredException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(402, e.getMessage(), e),
                HttpStatus.PAYMENT_REQUIRED);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardResponse> handleDuplicateRequestException(HttpMessageNotReadableException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(409, e.getMessage(), e),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NoHandlerFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, e.getMessage(), e),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<StandardResponse> handleHttpClientErrorException(HttpClientErrorException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(e.getRawStatusCode(), e.getStatusText(), e),
                HttpStatus.valueOf(e.getRawStatusCode()));
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<StandardResponse> handleHttpServerErrorException(HttpServerErrorException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(e.getRawStatusCode(), e.getStatusText(), e),
                HttpStatus.valueOf(e.getRawStatusCode()));
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardResponse> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(400, e.getMessage(), e),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingCsrfTokenException.class)
    public ResponseEntity<StandardResponse> handleMissingCsrfTokenException(MissingCsrfTokenException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(403, e.getMessage(), e),
                HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StandardResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(500, e.getMessage(), e),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

}