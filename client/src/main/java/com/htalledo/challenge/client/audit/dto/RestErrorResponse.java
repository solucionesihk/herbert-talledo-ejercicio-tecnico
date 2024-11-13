package com.htalledo.challenge.client.audit.dto;

import lombok.Builder;
import lombok.Value;

import java.io.Serial;
import java.io.Serializable;

@Value
@Builder
public class RestErrorResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = -1415932264184516029L;

  @Builder.Default
  String requestId = "";
  @Builder.Default
  ErrorType type = ErrorType.EXCEPTION;
  @Builder.Default
  Integer code = 500;
  @Builder.Default
  String message = "";
  @Builder.Default
  String module = "";
}
