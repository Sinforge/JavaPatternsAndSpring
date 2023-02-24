package sinforge.practice22;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@org.aspectj.lang.annotation.Aspect
public class MyAspect {
    private long startTime;

    @Before("allLog()")
    public void logMethod(JoinPoint joinPoint) {
        startTime = System.nanoTime();
        log.info("The method is now executed: " + joinPoint.getSignature());
    }
    @After("allLog()")
    public void endMethod(JoinPoint joinPoint) {
        log.info("The method "+ joinPoint.getSignature() +" ended in:" +
                ((System.nanoTime() - startTime) / 1_000_000_000)  +" ms");

    }



    @Pointcut("within(sinforge.practice20.Services.*)")
    public void allLog(){}
}
