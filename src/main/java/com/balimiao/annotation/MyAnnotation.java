package com.balimiao.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {

    String propert() default "";

    String methodName() default "";

    String indexName() default "";

}
