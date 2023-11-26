package software.ulpgc.moneycalculator.api;

import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.model.Currency;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.CurrencyLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class ApiCurrencyLoader2 implements CurrencyLoader {

    private final static String API_KEY = "fca_live_RjvYQ7rDVQ68DMVFwo7DCApxorVA8fO9ttKlXruw";
    private final static String Url = "https://api.freecurrencyapi.com/v1/currencies?apikey=:API_KEY:";
    @Override
    public List<Currency> load() {
        try {
            return load(readCurrencies());
        } catch (IOException e) {
            return emptyList();
        }
    }
    private List<Currency> load(String json) {
        return load(symbolsIn(json));
    }

    private List<Currency> load(Map<String, JsonElement> symbols) {
        return symbols.keySet().stream()
                .map(k -> toCurrency(k, symbols.get(k).getAsJsonObject().get("name").getAsString()))
                .collect(toList());
    }

    private static Map<String, JsonElement> symbolsIn(String json) {
        return new Gson()
                .fromJson(json, JsonObject.class)
                .get("data")
                .getAsJsonObject()
                .asMap();
    }

    private static Currency toCurrency(String code, String name) {
        return new Currency(code, name);
    }

    private String readCurrencies() throws IOException {
        try (InputStream is = new URL(Url.replace(":API_KEY:", API_KEY)).openStream()) {
            return new String(is.readAllBytes());
        }
    }

}
