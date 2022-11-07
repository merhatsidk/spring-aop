package edu.miu.cs545.restApi.aspect;

import edu.miu.cs545.restApi.domain.ExceptionTable;
import edu.miu.cs545.restApi.domain.Logger;
import edu.miu.cs545.restApi.repo.ExceptionRepo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class ExceptionAspect {
    @Autowired
    private ExceptionRepo exceptionRepo;

    @AfterThrowing(value = "@within(org.springframework.web.bind.annotation.RestController)",throwing = "ex")
    public void logOperation(JoinPoint joinPoint,Exception ex){
        var x = ExceptionTable.builder()
                        .dateTime(new Date())
                                .principle("Mersh")
                                        .operation(joinPoint.getSignature().getName())
                                                .exceptionType(ex.getClass().getName())
                                                        .build();
        exceptionRepo.save(x);

    }
}
