package com.biscuit.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author biscuit
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
public @interface IgnoreLogin {
}
