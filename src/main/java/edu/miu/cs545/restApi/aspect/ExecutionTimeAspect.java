package edu.miu.cs545.restApi.aspect;

import edu.miu.cs545.restApi.dto.UserDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {


    @Pointcut("@annotation(edu.miu.cs545.restApi.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object execution(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        UserDto result = (UserDto) joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("time took to complete " + joinPoint.getSignature().getName() + " is " + (end - start));

        return result;
    }
}

