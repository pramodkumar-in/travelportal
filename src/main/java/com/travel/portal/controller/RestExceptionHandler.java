package com.travel.portal.controller;

import com.travel.portal.dto.APIErrorResponse;
import com.travel.portal.exceptions.EntityNotCreatedException;
import com.travel.portal.exceptions.RequestDetailsNotValidException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new APIErrorResponse(HttpStatus.BAD_REQUEST, error, ex));
    }

    private ResponseEntity<Object> buildResponseEntity(APIErrorResponse apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


    //other exception handlers below

    @ExceptionHandler(EntityNotCreatedException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotCreatedException ex) {
        APIErrorResponse apiError = new APIErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(RequestDetailsNotValidException.class)
    protected ResponseEntity<Object> roomDetailsNotFound(
            RequestDetailsNotValidException ex) {
        APIErrorResponse apiError = new APIErrorResponse(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
}
