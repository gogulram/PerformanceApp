package in.gogul.Exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import in.gogul.model.ApiError;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ApiException.class)
	@ResponseBody
	public ResponseEntity<ApiError> handleApiException(ApiException apiException, HttpServletRequest request)

	{
		ApiError apiErrorResponse = new ApiError();
		apiErrorResponse.setMessage(apiException.getMessage());
		apiErrorResponse.setCode("34");
		return new ResponseEntity<>(apiErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
