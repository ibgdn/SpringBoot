package com.ice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 25.Spring Boot 整合 AOP
 */
@Component
@Aspect
public class AopLogComponent {
    // execution(*[返回值，任意] com.ice.aop.service[包名].*[类，任意].*[方法，任意](..[参数类型、个数，任意]))
    @Pointcut(value = "execution(* com.ice.aop.service.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        // 拿到执行的方法名
        String name = joinPoint.getSignature().getName();
        System.out.println("JoinPoint Before name: " + name);
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("JoinPoint After name: " + name);
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("JoinPoint AfterReturning name: " + name + ", returning: " + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String name = joinPoint.getSignature().getName();
        System.out.println("JoinPoint AfterThrowing name: " + name + ", throwing: " + e.getMessage());
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("ProceedJoinPoint Around Before proceed()");
        joinPoint.proceed();
        System.out.println("ProceedJoinPoint Around After proceed()");
        return joinPoint.toString();
    }
}
