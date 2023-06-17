package com.kronempire.game.config;

import com.kronempire.game.service.PendingConstruction;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Autowired
    private PendingConstruction pendingConstruction;

    @PostConstruct
    public void init() {
        pendingConstruction.resetQueue();
    }
}
