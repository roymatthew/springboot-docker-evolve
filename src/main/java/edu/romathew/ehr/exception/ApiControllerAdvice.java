package edu.romathew.ehr.exception;

import edu.romathew.ehr.domain.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(AbstractApiException exception) {
        return ResponseEntity.badRequest().body(exception.getErrorResponse());
    }
}
