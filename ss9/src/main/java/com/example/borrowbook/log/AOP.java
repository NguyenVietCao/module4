package com.example.borrowbook.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class AOP {
    private int count = 0;
    @Pointcut("within(com.example.borrowbook.controller.BookRentalController*)")
    public void methodPoinCut(){

    }
    @After("methodPoinCut()")
    public void methodAfter(JoinPoint joinPoint){
        count++;
        System.err.println(joinPoint.getSignature()+"số khách đến thư viện là"+ count);
    }
    @Pointcut("execution(* com.example.borrowbook.controller.BookRentalController.get*(..))")
    public void borrowAndPay(){

    }
    @After("borrowAndPay()")
    public void borrowAndPayAfter(JoinPoint joinPoint){
        System.err.println(joinPoint.getSignature().getName() +"thoi gian" + LocalDateTime.now());
    }
}
