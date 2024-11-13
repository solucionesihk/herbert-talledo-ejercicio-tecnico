package com.htalledo.challenge.account.audit.util;

import lombok.val;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

  private ExceptionUtil() {
    throw new UnsupportedOperationException();
  }

  public static String getStackTrace(Throwable e) {
    if (e == null) return null;

    val output = new StringWriter();
    e.printStackTrace(new PrintWriter(output));

    return output.toString();
  }
}
