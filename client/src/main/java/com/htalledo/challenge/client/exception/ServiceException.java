package com.htalledo.challenge.client.exception;

import com.htalledo.challenge.client.audit.dto.ErrorType;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serial;

@Getter
public class ServiceException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 4557794027358404786L;

  @NonNull
  private final ErrorType errorType;
  private final String module;

  public ServiceException(@NonNull ErrorType errorType) {
    this.errorType = errorType;
    this.module = "";
  }

  public ServiceException(@NonNull String message, @NonNull ErrorType errorType) {
    super(message);
    this.errorType = errorType;
    this.module = "";
  }

  public ServiceException(@NonNull String message, @NonNull Throwable cause, @NonNull ErrorType errorType) {
    super(message, cause);
    this.errorType = errorType;
    this.module = "";
  }

  public ServiceException(@NonNull Throwable cause, @NonNull ErrorType errorType) {
    super(cause);
    this.errorType = errorType;
    this.module = "";
  }

  public ServiceException(@NonNull ErrorType errorType, String module) {
    this.errorType = errorType;
    this.module = module;
  }

  public ServiceException(@NonNull String message, @NonNull ErrorType errorType, String module) {
    super(message);
    this.errorType = errorType;
    this.module = module;
  }

  public ServiceException(@NonNull String message, @NonNull Throwable cause, @NonNull ErrorType errorType, String module) {
    super(message, cause);
    this.errorType = errorType;
    this.module = module;
  }

  public ServiceException(@NonNull Throwable cause, @NonNull ErrorType errorType, String module) {
    super(cause);
    this.errorType = errorType;
    this.module = module;
  }
}
