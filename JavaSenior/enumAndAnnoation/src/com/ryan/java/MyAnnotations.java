package com.ryan.java;

import java.lang.annotation.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/22
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
