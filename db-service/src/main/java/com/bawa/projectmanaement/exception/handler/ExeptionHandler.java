package com.bawa.projectmanaement.exception.handler;

import com.bawa.projectmanaement.exception.OrderCouldNotExeption;
import com.bawa.projectmanaement.exception.OrderCouldNotExeptionResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ExeptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleProjectIDNotUniqException(OrderCouldNotExeption ex, WebRequest request){
        OrderCouldNotExeptionResponse projectIDNotUniqExeptionResponse = new OrderCouldNotExeptionResponse(ex.getMessage());
        return handleExceptionInternal(ex, projectIDNotUniqExeptionResponse,new HttpHeaders(),HttpStatus.SERVICE_UNAVAILABLE,request);
    }
}
