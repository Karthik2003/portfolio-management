package com.kristal.pm.controllers;

import com.kristal.pm.dto.PortfolioDetails;
import com.kristal.pm.service.PortfolioManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/portfolio-management")
@Slf4j
public class PortfolioManagementController {

    @Autowired
    PortfolioManagementService pmService;

    @GetMapping("/{accountId}")
    public PortfolioDetails getPortfolioById(@PathVariable(value = "accountId") String accountId) {
        log.info("get Portfolio By account Id {}", accountId);
        return pmService.getPortfolioById(accountId);
    }
}
