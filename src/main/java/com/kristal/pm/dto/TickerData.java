package com.kristal.pm.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TickerData {
    private String assetName;
    private String assetSymbol;
    private Integer assetVolume;
    private Double assetUnitPrice;
    private Double assetNetValue;
}
