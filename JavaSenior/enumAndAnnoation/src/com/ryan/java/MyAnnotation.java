package com.ryan.java;

import java.lang.annotation.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/22
 */
@Documented
@Repeatable(MyAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.TYPE_USE})
public @interface MyAnnotation {

    String value() default "hello";
}
