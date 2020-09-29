package com.kristal.pm.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PortfolioDetails {

    @JsonIgnore
    private String id;
    private String accountId;
    private Double assetTotalValue;
    private List<TickerData> tickerDataList;
}
