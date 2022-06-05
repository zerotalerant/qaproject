package org.example.service;

import org.example.entity.CurrencyEntity;
import org.example.model.CurrencyModel;

import java.util.List;

public interface CurrencyService {
    CurrencyModel createNewCurrency ( CurrencyModel currency );

    CurrencyModel getCurrencyById ( CurrencyEntity currencyId );

    Object updateCurrency ( CurrencyModel currencyModel );

    List<CurrencyModel> getAllCurrencies ();
}
