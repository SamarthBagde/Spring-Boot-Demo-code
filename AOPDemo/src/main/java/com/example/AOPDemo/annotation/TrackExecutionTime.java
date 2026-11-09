package com.example.AOPDemo.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//This is configured annotation
@Target(ElementType.METHOD) // this annotation can only used on method
@Retention(RetentionPolicy.RUNTIME) // this retain our annotation during runtime (this is default)
public @interface TrackExecutionTime {
    long warnAfter() default 2000; // default value is 2000 if not provided by user
    String operation() default  "";
}
