package shared.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shared.RequestResponse;

@RestControllerAdvice
public class ApiExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RequestResponse> handleError(Exception e) {
		return new ResponseEntity<RequestResponse>(new RequestResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
	}
}
