package com.udemy.myCoolApp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


   @Pointcut("execution(* com.udemy.myCoolApp.dao.*.*(..))")
   private void forDaoPackage() {}

    //create pointcut for getter methods
    @Pointcut("execution(* com.udemy.myCoolApp.dao.*.get*(..))")
    private void getter() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.udemy.myCoolApp.dao.*.set*(..))")
    private void setter() {}

    //create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {}

    //@Before("execution(public void add*())")
    //@Before("execution(void add*(com.udemy.myCoolApp.Account, ..))")
    //@Before("execution(* com.udemy.myCoolApp..add*(..))")
    //@Before("execution(* com.udemy.myCoolApp.dao.*.*(..))")//any access modifier any class any method any params
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
