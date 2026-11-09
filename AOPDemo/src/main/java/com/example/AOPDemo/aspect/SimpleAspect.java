package com.example.AOPDemo.aspect;

import com.example.AOPDemo.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Around("@annotation(com.example.AOPDemo.annotation.TrackExecutionTime)")
//    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//
//        try {
//            return joinPoint.proceed();
//        }finally {
//            long endTime = System.currentTimeMillis();
//
//            long duration = endTime - startTime;
//
//            String methodName = joinPoint.getSignature().getName();
//
//            System.out.println("[measureExecutionTime] : " + methodName + " " + duration);
//        }
//    }

    //  This is also way to bind annotation if we dont want to give full path of annotation
    //In this we are using attributes defined in our custom configured annotation
    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                        TrackExecutionTime trackExecutionTime) throws Throwable {
        long startTime = System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;

            String operation = trackExecutionTime.operation();

            if (operation.isBlank()) {
                operation = joinPoint.getSignature().getName();
            }

            long warningThreshold = trackExecutionTime.warnAfter();

            if (duration >= warningThreshold) {
                System.out.println("SLOW OPERATION ALERT : " +
                        "Time Taken by " +
                        operation + ": " + duration);
            } else {
                System.out.println(
                        "Time Taken by " + operation + ": " + duration);
            }

        }
    }
}
