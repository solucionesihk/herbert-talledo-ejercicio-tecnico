package com.htalledo.challenge.client.config;

import com.htalledo.challenge.client.audit.EnableAuditConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EnableAuditConfig
public @interface EnableMicroserviceConfig {
}
