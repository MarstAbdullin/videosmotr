package ru.itis.semestrovaya.videosmotr.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Around(value= "execution(* ru.itis.semestrovaya.videosmotr.services.RegisterService.register(..))")
    public Object logRegister(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(timeTaken);
        return object;
    }

    @Before(value= "execution(* ru.itis.semestrovaya.videosmotr.services.VideoService.getCurrentVideo(..))")
    public void logConfirm(JoinPoint joinPoint) {
        System.out.println("Someone get current video");
    }
}
