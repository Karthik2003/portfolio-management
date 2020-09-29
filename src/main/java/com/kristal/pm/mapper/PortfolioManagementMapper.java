package com.kristal.pm.mapper;

import com.google.common.util.concurrent.AtomicDouble;
import com.kristal.pm.dto.PortfolioDetails;
import com.kristal.pm.dto.TickerData;
import com.kristal.pm.exception.APIException;
import com.kristal.pm.model.PortfolioEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.kristal.pm.exception.ServiceErrorMessage.UNEXPECTED_ERROR;

@Slf4j
public class PortfolioManagementMapper {

    private PortfolioManagementMapper() {super();}

    public static PortfolioDetails map(final List<PortfolioEntity> pmEntityList) {
        log.info("Portfolio Entity List {}", pmEntityList);
        final PortfolioDetails pmDetails = new PortfolioDetails();
        final List<TickerData> tickerDataList = new ArrayList<>();
        final AtomicDouble ad = new AtomicDouble(0.0d);
        try {
            pmEntityList.stream().forEach(pm -> {
                TickerData tickerData = new TickerData();
                pmDetails.setId(pm.getId());
                pmDetails.setAccountId(pm.getAccountId());
                tickerData.setAssetName(pm.getAssetName());
                tickerData.setAssetSymbol(pm.getAssetSymbol());
                tickerData.setAssetVolume(pm.getAssetVolume());
                tickerData.setAssetUnitPrice(pm.getAssetTickerEntity().getUnitPrice());
                tickerData.setAssetNetValue(tickerData.getAssetVolume() * tickerData.getAssetUnitPrice());
                ad.addAndGet(tickerData.getAssetNetValue());
                tickerDataList.add(tickerData);
            });
            pmDetails.setTickerDataList(tickerDataList);
            pmDetails.setAssetTotalValue(ad.get());
        } catch (Exception e) {
            throw APIException.internalError(UNEXPECTED_ERROR.getErrorCode(), e.getMessage());
        }
        return pmDetails;
    }
}