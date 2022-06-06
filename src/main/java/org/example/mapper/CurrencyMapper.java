package org.example.mapper;

import org.example.entity.CurrencyEntity;
import org.example.model.CurrencyModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Currency;
import java.util.List;

@Mapper
public interface CurrencyMapper {
    CurrencyMapper INSTANCE = Mappers.getMapper ( CurrencyMapper.class );

    CurrencyEntity toCurrencyEntity ( CurrencyModel currencyRequest );

    CurrencyModel toCurrencyEntity ( Currency currency );

    CurrencyModel toCurrencyModel ( CurrencyEntity currencyRequest );

    List<CurrencyModel> toCurrencyEntity ( List<CurrencyEntity> currencies );
}
