package com.kristal.pm.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationEventListener implements ApplicationListener {

    @Value("${spring.application.name}")
    private String appName;

    @Override
    public void onApplicationEvent(final ApplicationEvent event) {
        if(event instanceof ApplicationStartingEvent) {
            log.info("Starting Application {}", appName);
        }
        log.info(event.getClass().getName());
    }
}