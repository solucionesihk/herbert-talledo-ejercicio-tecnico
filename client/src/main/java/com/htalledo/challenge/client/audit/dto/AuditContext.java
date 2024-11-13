package com.htalledo.challenge.client.audit.dto;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value
@Builder
@With
public class AuditContext {
  String requestId;
  String authorization;
  String isTokenAuthorizer;
  String userId;
  Throwable exception;
}
