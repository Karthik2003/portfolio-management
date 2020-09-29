package com.kristal.pm.service;

import com.kristal.pm.dto.PortfolioDetails;
import com.kristal.pm.exception.APIException;
import com.kristal.pm.mapper.PortfolioManagementMapper;
import com.kristal.pm.model.PortfolioEntity;
import com.kristal.pm.repository.PortfolioManagementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kristal.pm.exception.ServiceErrorMessage.ACCOUNT_ID_NOT_FOUND;

@Service
@Slf4j
public class PortfolioManagementService {

    @Autowired
    private PortfolioManagementRepository pmRepository;

    public PortfolioDetails getPortfolioById(String accountId) {
        log.info("Portfolio Details Id {}", accountId);
        List<PortfolioEntity> pmEntity = pmRepository.getPortfolioById(accountId).orElseThrow(() -> APIException.notFound(ACCOUNT_ID_NOT_FOUND.getErrorCode(), ACCOUNT_ID_NOT_FOUND.getErrorDesc()));
        return PortfolioManagementMapper.map(pmEntity);
    }
}
