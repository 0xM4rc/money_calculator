package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.api.ApiCurrencyLoader;
import software.ulpgc.moneycalculator.api.ApiExchangeRateLoader;

import software.ulpgc.moneycalculator.control.ExchangeCommand;

import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.swing.MainFrame;

import java.util.List;

public class MainSwing {
    public static void main(String[] args) {

        MainFrame frame = new MainFrame();
        CurrencyLoader currencyLoader = new ApiCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();
        ExchangeRateLoader exchangeRateLoader = new ApiExchangeRateLoader();
        MoneyDialog moneyDialog = frame.getMoneyDialog().define(currencies);
        CurrencyDialog currencyDialog = frame.getCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = frame.getMoneyDisplay();
        frame.add("exchange", new ExchangeCommand(moneyDialog, currencyDialog, exchangeRateLoader, moneyDisplay));
        frame.setVisible(true);
    }
}
