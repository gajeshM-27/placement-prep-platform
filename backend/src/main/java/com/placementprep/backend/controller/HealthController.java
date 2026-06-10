package com.placementprep.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    public HealthController() {
        System.out.println("HealthController Loaded!");
    }

    @GetMapping("/api/health")
    public String health() {
        return "Placement Prep Backend Running!";
    }
}