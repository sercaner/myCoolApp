package com.udemy.myCoolApp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //@Before("execution(public void add*())")
    //@Before("execution(void add*(com.udemy.myCoolApp.Account, ..))")
    //@Before("execution(* com.udemy.myCoolApp..add*(..))")
    //@Before("execution(* com.udemy.myCoolApp.dao.*.*(..))")//any access modifier any class any method any params
    @Before("com.udemy.myCoolApp.aspect.AppAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method");
    }
}
