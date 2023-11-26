package software.ulpgc.moneycalculator.api;

import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.model.Currency;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class APICurrencyLoader implements CurrencyLoader {

    @Override
    public List<Currency> load() {
        return null; //toCurrency();

    }

    public List<Currency> toCurrency(){
        /*
        List<Currency> returnCurrencies = new ArrayList<>();
        APIExchangeRateLoader api = new APIExchangeRateLoader();
        Map<String, Double> availableCurrencies = api.load();

        CurrencyLoader csvLoader = CSVCurrencyLoader.with(new File( "C:\\Users\\marc\\Desktop\\Tercero\\IS2\\money_calculator\\src\\main\\resources\\Currencies.csv"));
        List<Currency> allCurrencies = csvLoader.load();
        for (Currency currency:
             allCurrencies) {
            if(availableCurrencies.containsKey(currency.code())){
                returnCurrencies.add(currency);
            }
        }
        return returnCurrencies;
        */
         return null;
    }
}
