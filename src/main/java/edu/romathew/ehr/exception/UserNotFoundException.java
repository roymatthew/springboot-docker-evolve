package edu.romathew.ehr.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AbstractApiException {

    private Exception exception;

    public UserNotFoundException() {
        super.setErrorResponse(ErrorResponse.builder()
                .location("UserService")
                .status(HttpStatus.NOT_FOUND)
                .message("User Not Found!")
                .cause("No matching resource found in the system")
                .applicationErrorCode("U1000")
                .build());
    }

    public UserNotFoundException(ErrorResponse errorResponse) {
        super.setErrorResponse(errorResponse);
    }

    public UserNotFoundException(Exception ex, ErrorResponse errorResponse) {
        super.setErrorResponse(errorResponse);
        this.exception = ex;
    }

    @Override
    public ErrorResponse mapErrorResponse() {
        return ErrorResponse.builder()
                .location(super.getErrorResponse().getLocation())
                .status(super.getErrorResponse().getStatus())
                .message(this.exception.getMessage())
                .cause(super.getErrorResponse().getCause())
                .applicationErrorCode(super.getErrorResponse().getApplicationErrorCode())
                .build();
    }
}
