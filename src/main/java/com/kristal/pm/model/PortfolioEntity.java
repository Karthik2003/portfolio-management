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
@Table(name = "portfolio_details_t")
public class PortfolioEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", length = 100, updatable = false, nullable = false)
    private String id;

    @Column(name = "account_id", length = 30, nullable = false)
    private String accountId;

    @Column(name = "asset_name", length = 60, nullable = false)
    private String assetName;

    @Column(name = "asset_symbol", length = 20, nullable = false)
    private String assetSymbol;

    @Column(name = "asset_volume", length = 12, nullable = false)
    private Integer assetVolume;

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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asset_symbol", referencedColumnName = "asset_symbol", insertable = false, updatable = false)
    private AssetTickerEntity assetTickerEntity;
}
