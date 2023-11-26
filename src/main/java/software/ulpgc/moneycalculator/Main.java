package software.ulpgc.moneycalculator;

//import software.ulpgc.moneycalculator.mock.*;
import software.ulpgc.moneycalculator.api.APICurrencyLoader;
import software.ulpgc.moneycalculator.api.APIExchangeRateLoader;
import software.ulpgc.moneycalculator.api.ApiCurrencyLoader2;
import software.ulpgc.moneycalculator.model.Currency;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Dependencies
        ExchangeRateLoader exchangeLoader = new APIExchangeRateLoader();


        /*MockCurrencyLoader currencyLoader = new MockCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        MoneyDialog moneyDialog = new CliMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = new CliCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();
        ExchangeCommand exchangeCommand = new ExchangeCommand(moneyDialog, currencyDialog, exchangeRateLoader, moneyDisplay);
        exchangeCommand.execute();
        */
        // Load exchanges rates
        /*
        Map<String, Double> exchangerates = exchangeLoader.load(new Currency("EUR", "dolar"));

        for (Map.Entry<String, Double> entry : exchangerates.entrySet()) {
            System.out.println("Moneda: " + entry.getKey() + ", Valor: " + entry.getValue());
        }


        CurrencyLoader currencyLoader =  new APICurrencyLoader();
        currencyLoader.load();


        CurrencyLoader csvCurrencyLoader = CSVCurrencyLoader.with(new File("C:\\Users\\marc\\Desktop\\Tercero\\IS2\\money_calculator\\src\\main\\resources\\Currencies.csv"));
        List<Currency> currencyList = csvCurrencyLoader.load();
        for (Currency currency :
                currencyList) {
            if (currency.code())
        }

         */

        CurrencyLoader loader = new ApiCurrencyLoader2();
        System.out.println(loader.load());
    }
}
