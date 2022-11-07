package edu.miu.cs545.restApi.aspect;

import edu.miu.cs545.restApi.domain.Logger;
import edu.miu.cs545.restApi.repo.LoggerRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    private LoggerRepo loggerRepo;

    @After("@within(org.springframework.stereotype.Service)")
    public void logOperation(JoinPoint joinPoint){
        var x = Logger.builder()
                .dateTime(new Date())
                .principle("Mersh")
                .operation(joinPoint.getSignature().getName())
                .build();
        loggerRepo.save(x);

    }
}
