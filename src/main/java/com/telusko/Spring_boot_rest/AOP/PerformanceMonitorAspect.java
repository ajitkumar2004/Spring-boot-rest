package com.telusko.Spring_boot_rest.AOP;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    public void monitorTime()
    {

    }

}
