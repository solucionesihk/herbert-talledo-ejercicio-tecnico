package com.htalledo.challenge.account.audit.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorLog {

  String requestId;
  ErrorType type;
  String stackTrace;
  String base64Request;
}
