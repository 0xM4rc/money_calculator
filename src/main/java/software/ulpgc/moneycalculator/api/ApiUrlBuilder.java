package software.ulpgc.moneycalculator.api;


import software.ulpgc.moneycalculator.model.Currency;

public class ApiUrlBuilder {
    private static final String API_KEY = "fca_live_RjvYQ7rDVQ68DMVFwo7DCApxorVA8fO9ttKlXruw";
    private static final String URL = "https://api.freecurrencyapi.com/v1/:OPTIONS:?apikey=:API_KEY:";
    private enum OPTIONS {
        latest,  currencies
    }

    public static String curreciesUrl() {
        return URL.replace(":OPTIONS:", OPTIONS.currencies.toString())
                .replace(":API_KEY:", API_KEY);
    }

    public static String exchangeUrl(Currency from, Currency to) {
        return (URL+"&currencies=:TO_EXCHANGE:&base_currency=:BASE_CURRENCY:")
                .replace(":OPTIONS:", OPTIONS.latest.toString())
                .replace(":API_KEY:", API_KEY)
                .replace(":BASE_CURRENCY:", from.code())
                .replace(":TO_EXCHANGE:",to.code());
    }
}
