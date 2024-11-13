package com.htalledo.challenge.client.audit;

import com.htalledo.challenge.client.audit.dto.AuditContext;
import lombok.val;

public class AuditContextHolder {
  private static final ThreadLocal<AuditContext> auditContext = new ThreadLocal<>();

  private AuditContextHolder() {
    throw new UnsupportedOperationException();
  }

  public static AuditContext getAuditContext() {
    val threadContext = auditContext.get();

    if (threadContext != null) {
      return threadContext;
    }

    AuditContextHolder.setAuditContext(AuditContext.builder().build());

    return auditContext.get();
  }

  public static void setAuditContext(AuditContext auditContext) {
    AuditContextHolder.auditContext.set(auditContext);
  }
}
