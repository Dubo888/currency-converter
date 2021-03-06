package com.currencyconverter.services;

import com.currencyconverter.models.ConversionCurrency;
import com.currencyconverter.repositories.CurrencyRepository;
import com.currencyconverter.models.Currency;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    private CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAllCurrencies() {
        List<Currency> currencyList = this.currencyRepository.findAll();
        currencyList.sort(Comparator.comparing(Currency::getName));
        return currencyList;
    }

    public Optional<Double> convert(ConversionCurrency conversionCurrency) {
        Optional<Currency> toOptional = this.currencyRepository.findById(conversionCurrency.getTo().toUpperCase());
        Optional<Currency> fromOptional = this.currencyRepository.findById(conversionCurrency.getFrom().toUpperCase());

        if(toOptional.isPresent() && fromOptional.isPresent()) {

            if(conversionCurrency.getValue() < 0) {
                return Optional.empty();
            }

            Currency to = toOptional.get();
            Currency from = fromOptional.get();
            Double toValue = to.getValueInEuros();
            Double fromValue = from.getValueInEuros();

            Double result = toValue * conversionCurrency.getValue() / fromValue;

            return Optional.of(result);

        }

        return Optional.empty();
    }

}
