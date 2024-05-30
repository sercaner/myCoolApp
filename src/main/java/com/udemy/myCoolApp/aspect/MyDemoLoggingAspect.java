package com.udemy.myCoolApp.aspect;

import com.udemy.myCoolApp.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
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
    public void beforeAddAccountAdvice(JoinPoint  theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method");

        //display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();

        System.out.println("Method: "+ methodSignature);

        //display the method arguments

        //get args
        Object[] args = theJoinPoint.getArgs();

        //loop thru args
        for (Object tempArg : args) {
            System.out.println(tempArg);

            if (tempArg instanceof Account) {

                //downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: "+ theAccount.getName());
                System.out.println("account level: "+ theAccount.getLevel());
            }
        }
    }
}
