package software.ulpgc.moneycalculator.api;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import software.ulpgc.moneycalculator.CurrencyLoader;
import software.ulpgc.moneycalculator.model.Currency;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public class ApiCurrencyLoader implements CurrencyLoader {
    @Override
    public List<Currency> load() {
        try {
            return toList(loadJson());
        } catch (IOException e) {
            return emptyList();
        }
    }

    private List<Currency> toList(String json) {
        List<Currency> list = new ArrayList<>();

        JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();
        JsonObject dataObject = jsonObject.getAsJsonObject("data");

        for (String symbol : dataObject.keySet()) {
            JsonObject currencyObject = dataObject.getAsJsonObject(symbol);
            String code = currencyObject.get("code").getAsString();
            String name = currencyObject.get("name").getAsString();
            list.add(new Currency(code, name));
        }

        return list;
    }

    private String loadJson() throws IOException {
        try (InputStream is = new URL(ApiUrlBuilder.curreciesUrl()).openStream()) {
            return new String(is.readAllBytes());
        }
    }
}
