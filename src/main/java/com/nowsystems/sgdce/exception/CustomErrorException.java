package com.nowsystems.sgdce.exception;




import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomErrorException extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    // error handle for @Valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
            final HttpHeaders headers, final HttpStatus status, final WebRequest request) {

        final ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setTimestamp(new Date());
        exceptionResponse.setStatus(status.value());

        // Get all errors
        final List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        exceptionResponse.setMessages(errors);
        exceptionResponse.setDetails(request.getDescription(false));

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(ApiException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(final ApiException ex,
            final WebRequest request) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                Arrays.asList(ex.getMessage()),
                request.getDescription(false),HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


}
