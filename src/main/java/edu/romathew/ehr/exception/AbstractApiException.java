package edu.romathew.ehr.exception;

public abstract class AbstractApiException extends Exception implements ApiException {

    private ErrorResponse errorResponse;

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}
