package org.example.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.CurrencyEntity;
import org.example.exceptions.CurrencyNotFoundException;
import org.example.exceptions.FieldCantBeEmptyException;
import org.example.model.CurrencyModel;
import org.example.repository.CurrencyRepository;
import org.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;


    @Override
    public CurrencyModel createNewCurrency ( CurrencyModel currencyModel )
    {
        if ( currencyModel == null )
        {
            throw new CurrencyNotFoundException ( "currency is null" );
        }
        CurrencyEntity currency = new CurrencyEntity ();
        currency.setCurrencyChar ( currencyModel.getCharCode () );
        currency.setCurrencyName ( currencyModel.getCurrencyName () );
        currency.setCurrencyValue ( currencyModel.getValue () );

        currency = currencyRepository.save ( currency );

        currency.setId ( currency.getId () );

        return currencyModel;

    }

    @Override
    public CurrencyModel getCurrencyById ( CurrencyEntity currencyId )
    {
        if ( currencyId == null )
        {
            throw new FieldCantBeEmptyException ( "id is null" );
        }
        CurrencyEntity existEntity = currencyRepository.getById ( currencyId );

        if ( existEntity == null )
        {
            throw new FieldCantBeEmptyException ( "Currency not found" );
        }

        CurrencyModel existModel = new CurrencyModel ();
        existModel.setCurrencyName ( existEntity.getCurrencyName () );
        existModel.setCharCode ( existEntity.getCurrencyChar () );
        existModel.setNominal ( Double.valueOf ( existEntity.getNominal () ) );
        existModel.setValue ( existEntity.getCurrencyValue () );

        return existModel;
    }

    @Override
    public Object updateCurrency ( CurrencyModel currencyModel )
    {
        if ( currencyModel == null )
        {
            throw new FieldCantBeEmptyException ( "Currency model is  null" );
            CurrencyEntity existCurrency = currencyRepository.getById ( currencyModel.getId () );
            if ( existCurrency == null )
            {
                throw new RuntimeException ( "Currency by id: " + currencyModel.getId () + " doesn't exist" );
            }

            existCurrency.setCurrencyValue ( currencyModel.getValue () );
            existCurrency.setCurrencyChar ( currencyModel.getCharCode () );
            existCurrency.setNominal ( currencyModel.getNominal () );
            existCurrency.setCurrencyName ( currencyModel.getCurrencyName () );

            existCurrency = currencyRepository.save ( existCurrency );

            return true;
        }

        @Override
        public List<CurrencyModel> getAllCurrencies ( )
        {
            List<CurrencyEntity> currencyEntityList = currencyRepository.findAll ();
            List<CurrencyModel> currencyModelList = new ArrayList<> ();
            for (CurrencyEntity currency : currencyEntityList)
            {
                currencyModel = new CurrencyModel ();
                currencyModel.setCurrencyName ( currency.getCurrencyName () );
                currencyModel.setCharCode ( currency.getCurrencyChar () );
                currencyModel.setNominal ( currency.getNominal () );
                currencyModel.setValue ( currency.getCurrencyValue () );
                currencyModelList.add ( currencyModel );
            }
            return currencyModelList;
        }
    }
}
