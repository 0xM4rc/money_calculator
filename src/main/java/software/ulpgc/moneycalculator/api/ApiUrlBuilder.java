package software.ulpgc.moneycalculator.api;

public class ApiUrlBuilder {
    private static final String API_KEY = "fca_live_RjvYQ7rDVQ68DMVFwo7DCApxorVA8fO9ttKlXruw";

    public static String fromUrl(String currency){
        return "https://api.freecurrencyapi.com/v1/latest?apikey=:API_KEY:&currencies=&base_currency=:CURRENCY:"
                .replace(":API_KEY:", API_KEY)
                .replace(":CURRENCY:", currency);
    }


    public static String defaultUrl() {
        return "https://api.freecurrencyapi.com/v1/latest?apikey=:API_KEY:"
                .replace(":API_KEY:", API_KEY);
    }
}
