package com.example.AOPDemo.aspect;

import com.example.AOPDemo.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class loggingAspect {

    /*
    * We can't stop execution of target method using @Before,
    * even we return in @Before it will ignore it
    *
    * but there is one way to do it is throug exception in @Before
    *
    * ------
    * Using joinPoint in @Before we can access argument of target method, even joiPoint have all info about traget method
    *
    * */

                        // Return Type   Path
//    @Before("execution(String com.example.AOPDemo.service.StudentService.createStudent(com.example.AOPDemo.dto.Student))")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//        System.out.println("Student is going to save");
//
////        boolean allowed = false;
////
////        if(!allowed){
////            throw new RuntimeException("Method Execution not allowed")
////        }
//
////        Object[] arr = joinPoint.getArgs(); // this will give argument in targeted method in array of Object format
////        //Note: we cant modify argument, only read is allowed
////
////        Student student = (Student) arr[0];
////
////        System.out.println("Name: " + student.getName());
//    }


    /*
    * This runs only when target method returned successfully without any exception
    *
    * if target method throw exception then this will not get called
    * if target method handler exception in try catch then this logic will called
    *
    * In this we can access the return value of target method, but we cant modify or changes the return value
    * client always get original return value of target method
    * */

//    @AfterReturning(
//            value = "execution(String com.example.AOPDemo.service.StudentService.createStudent(com.example.AOPDemo.dto.Student))",
//            returning = "result") // this will give access to return value of target method)
//    public void logAfterReturningMethod(String result){
//        System.out.println("[logAfterReturningMethod] : Target method is returned");
//        System.out.println("[logAfterReturningMethod] : Return value: " + result);
//
//    }



    /*
    * This runs only when target method throw exception
    *
    * We cant catch exception in this
    * So we cant handler or comsume exception in AfterThrowing, we can only moniter it
    *
    *
    * we cant return anything for AfterThrowing
    * */
//    @AfterThrowing(
//            value = "execution(String com.example.AOPDemo.service.StudentService.createStudent(com.example.AOPDemo.dto.Student))",
//            throwing = "exception") // this will give access to exception
//    public void logAfterThrowingMethod(Throwable exception){
//
//        System.out.println("[logAfterThrowingMethod] : Exception occured in target method");
//        System.out.println("[logAfterThrowingMethod] : Exception type: "+ exception.getClass().getName());
//
//    }

    /*
    * @After runs after traget method execution is completed successfully or throw exception
    *
    * in this also we only monitor, we cant change anything and cant return anything
    * */

//    @After("execution(String com.example.AOPDemo.service.StudentService.createStudent(com.example.AOPDemo.dto.Student))")
//    public void logAfterMethod(){
//        System.out.println("[logAfterMethod] : Log from @After advice");
//    }

    /*
    * Around runs before and after target method execution
    * Around have power to change and modifies arguments, return type, consume exception
    *
    * If we miss to call target method using joinPoint then target method never get called and client get no response
    *
    *
    * Around is same as normal java method that calls our target method, just before and after perform so9me infra logic
    *
    * In Around we can call our target method multiple times if we want
    * */

//    @Around("execution(String com.example.AOPDemo.service.StudentService.createStudent(com.example.AOPDemo.dto.Student))")
//    public String logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("[logAroundMethod] : Before target method");
//
//        String result = (String) joinPoint.proceed(); // this will run target method
//        //Note : is return value is not handled then @Around consume return value and client get noting in response
//
//        System.out.println("[logAroundMethod] : After target method");
//
//        //Here we can modify and change return type
//
//        //result += " This is Modified Result";
//
//        return result;
//    }



    //-----------------------------------------------------------------------------------------------
    //This point cut target all methods in StudentService
    //Here we used wild cards for flexible pointcut creation
//    @Around("execution(* com.example.AOPDemo.service..*(..))")
//    public String logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("[logAroundMethod] : Before target method");
//
//        String result = (String) joinPoint.proceed(); // this will run target method
//        //Note : is return value is not handled then @Around consume return value and client get noting in response
//
//        System.out.println("[logAroundMethod] : After target method");
//
//        return result;
//    }

    /*
    *
    * execution(* com.example.AOPDemo.service.StudentService.*(..)) -> match any method in StudentService
    * execution(* com.example.AOPDemo.service.StudentService.get*(..)) -> match any method starts with get in StudentService
    * execution(* com.example.AOPDemo.service.StudentService.*Student(..)) -> match any method ends with Student in StudentService
    * execution(* com.example.AOPDemo.service.StudentService.*(*)) -> match any method that takes one argument in StudentService
    * execution(* com.example.AOPDemo.service.*.*(..)) -> match any method in service package (not inside sub package)
    * execution(* com.example.AOPDemo.service..*(..)) -> match any method in service package (including sub package)
    *
    *
    * Note : .. wildcard cant be used for return type because return type is single entity
    *
    *
    * execution(* * (..)) -> this cover whole application (any method in any package),
    * but this expression will give exception because it try to cover whole application including server internal class like server (tomcat config classes) which cause and error
    *
    * Inserted of doing this we can define on base package
    * E#x : execution(* com.example.AOPDemo..* (..))
    * */


    //----------------------------------------------------------------------------------------------------

    //This will run for every method in StudentService class
//    @Around("within(com.example.AOPDemo.service.StudentService)")
//    public String logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("[logAroundMethod] : Before target method");
//
//        String result = (String) joinPoint.proceed(); // this will run target method
//        //Note : is return value is not handled then @Around consume return value and client get noting in response
//
//        System.out.println("[logAroundMethod] : After target method");
//
//        return result;
//    }

    /*
    *
    * within -> designator
    * within() designator is used to match method executions based on the class or package where the methods are declared.
    *
    * within(packageName.ClassName)
    *
    *
    *
    *
    * */
}
