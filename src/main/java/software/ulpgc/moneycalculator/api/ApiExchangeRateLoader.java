package software.ulpgc.moneycalculator.api;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalculator.ExchangeRateLoader;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ApiExchangeRateLoader implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to) {
        try {
            double rate = toRate(loadJson(from, to));
            return new ExchangeRate(from, to, null, rate);
        } catch (IOException e) {
            return null;
        }
    }

    private double toRate(String json) {
        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject dataObject = jsonObject.getAsJsonObject("data");
        String key = dataObject.entrySet().iterator().next().getKey();
        return dataObject.getAsJsonPrimitive(key).getAsDouble();
    }

    private String loadJson(Currency from, Currency to) throws IOException {
        try (InputStream is = new URL(ApiUrlBuilder.exchangeUrl(from, to)).openStream()) {
            return new String(is.readAllBytes());
        }
    }
}
