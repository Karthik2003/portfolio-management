package com.kristal.pm.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "asset_ticker_t")
public class AssetTickerEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 100, updatable = false, nullable = false)
    private String id;

    @Column(name = "asset_name", length = 60, nullable = false)
    private String assetName;

    @Column(name = "asset_symbol", length = 20, nullable = false)
    private String assetSymbol;

    @Column(name = "unit_price", length = 20, nullable = false)
    private Double unitPrice;

    @Column(name = "source_name", length = 100, updatable = false, nullable = false)
    private String sourceName;

    @Column(name = "created_by")
    @GeneratorType(type = LoggedUserGenerator.class, when = GenerationTime.INSERT)
    private String createdBy;

    @CreatedDate
    private LocalDateTime dateCreated;

    @Column(name = "updated_by")
    @GeneratorType(type = LoggedUserGenerator.class, when = GenerationTime.ALWAYS)
    private String updatedBy;

    @LastModifiedDate
    private LocalDateTime dateUpdated;

}
