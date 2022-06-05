package org.example.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.entity.CurrencyEntity;
import org.example.model.CurrencyModel;
import org.example.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(path = "api/currency")
@CrossOrigin(origins = "*", maxAge = 3600)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurrencyController {

    @Autowired
    final CurrencyService currencyService;

    @GetMapping(path = "/get/all-currencies")
    public List<CurrencyModel> getAllCurrencies ()
    {
        return currencyService.getAllCurrencies ();
    }

    @GetMapping(path = "/get/{currencyId}")
    public CurrencyModel getCurrencyById ( @RequestParam("currencyId") CurrencyEntity currencyId )
    {
        return currencyService.getCurrencyById ( currencyId );
    }

    @PostMapping(path = "/create")
    public CurrencyModel createCurrency ( @RequestBody CurrencyModel currencyModel )
    {
        return currencyService.createNewCurrency ( currencyModel );
    }

    @PutMapping(path = "/update")
    public Boolean updateCurrency ( @RequestBody CurrencyModel currencyModel )
    {
        return ( Boolean ) currencyService.updateCurrency ( currencyModel );
    }
}
