package com.htalledo.challenge.account.audit;

import com.htalledo.challenge.account.audit.dto.ErrorType;
import com.htalledo.challenge.account.audit.dto.RestErrorResponse;
import com.htalledo.challenge.account.exception.ServiceException;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.htalledo.challenge.account.audit.AuditContextHolder.getAuditContext;
import static com.htalledo.challenge.account.audit.AuditContextHolder.setAuditContext;

@ControllerAdvice
class ExceptionHandlerConfig extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ ServiceException.class })
  protected ResponseEntity<RestErrorResponse> handleException(ServiceException ex) {
    if (ex.getCause() != null)
      setAuditContext(getAuditContext().withException(ex.getCause()));
    else
      setAuditContext(getAuditContext().withException(ex));

    val responseBuilder = RestErrorResponse
      .builder()
      .type(ex.getErrorType())
      .message(ex.getMessage())
      .module(ex.getModule())
      .requestId(getAuditContext().getRequestId());

    switch (ex.getErrorType()) {
    case BUSINESS, INTEGRATION -> responseBuilder.code(400);
    case TIMEOUT -> responseBuilder.code(408);
    case SECURITY, EXCEPTION -> responseBuilder.code(500);
    }
    val response = responseBuilder.build();

    return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  protected ResponseEntity<RestErrorResponse> handleGenericError(Exception ex) {
    setAuditContext(getAuditContext().withException(ex));

    return ResponseEntity
      .internalServerError()
      .body(RestErrorResponse
        .builder()
        .type(ErrorType.EXCEPTION)
        .code(500)
        .message(ex.getMessage())
        .requestId(getAuditContext().getRequestId())
        .build());
  }
}
