package com.kristal.pm.repository;

import com.kristal.pm.model.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PortfolioManagementRepository extends JpaRepository<PortfolioEntity, String> {
    @Query("SELECT p FROM PortfolioEntity p, AssetTickerEntity a WHERE a.assetSymbol = p.assetSymbol AND p.accountId = :accountId")
    Optional<List<PortfolioEntity>> getPortfolioById(@Param("accountId") final String accountId);
}
