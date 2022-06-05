package org.example.repository;

import org.example.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {


    @Query(value = "update currency c c.currency_value =:currencyValue where c.id =:id", nativeQuery = true)
    Integer updateCurrency ( Long id, Double currencyValue );

    CurrencyEntity getById ( CurrencyEntity currencyId );
}
