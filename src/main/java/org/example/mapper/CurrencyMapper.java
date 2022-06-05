package org.example.mapper;

import org.example.entity.CurrencyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Currency;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper ( CurrencyMapper.class );

    Currency toCurrencyEntity ( CurrencyRequest currencyRequest );

    CurrencyResponse toCurrencyResponse ( Currency currency );

    CurrencyResponse toCurrencyResponse ( CurrencyRequest currencyRequest );

    List<CurrencyResponse> toCurrencyResponse ( List<Currency> currencies );
}
