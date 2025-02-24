package com.telusko.Spring_boot_rest.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);
@Before("execution(* com.telusko.Spring_boot_rest.service.JobService.update(..))||execution(* com.telusko.Spring_boot_rest.service.JobService.getAllJobs(..))")
public void logMethodCall(JoinPoint jp)
{
  LOGGER.info("method called"+jp.getSignature().getName());
}
  @After("execution(* com.telusko.Spring_boot_rest.service.JobService.update(..))||execution(* com.telusko.Spring_boot_rest.service.JobService.getAllJobs(..))")
  public void logMethodExicute(JoinPoint jp)
  {
    LOGGER.info("method Exicute"+jp.getSignature().getName());
  }

}
