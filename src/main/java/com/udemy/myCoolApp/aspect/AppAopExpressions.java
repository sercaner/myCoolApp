package com.udemy.myCoolApp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //optional
public class AppAopExpressions {

    @Pointcut("execution(* com.udemy.myCoolApp.dao.*.*(..))")
    public void forDaoPackage() {}

    //create pointcut for getter methods
    @Pointcut("execution(* com.udemy.myCoolApp.dao.*.get*(..))")
    public void getter() {}

    //create pointcut for setter methods
    @Pointcut("execution(* com.udemy.myCoolApp.dao.*.set*(..))")
    public void setter() {}

    //create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
