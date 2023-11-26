package software.ulpgc.moneycalculator.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import software.ulpgc.moneycalculator.ExchangeRateLoader;
import software.ulpgc.moneycalculator.model.Currency;
import software.ulpgc.moneycalculator.model.ExchangeRate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class APIExchangeRateLoader implements ExchangeRateLoader {
    
    private String apiUrl = "https://api.freecurrencyapi.com/v1/latest?apikey=fca_live_RjvYQ7rDVQ68DMVFwo7DCApxorVA8fO9ttKlXruw";

    public Map<String, Double> JSONtoMap(String json) {

        // Parsear el JSON con Gson
        Gson gson = new Gson();
        JsonObject jsonResponse = gson.fromJson(json, JsonObject.class);

        // Obtener el objeto "data" del JSON
        JsonObject dataObject = jsonResponse.getAsJsonObject("data");

        // Crear un mapa para almacenar los pares clave-valor
        Map<String, Double> keyValuePairs = new HashMap<>();

        // Iterar sobre las entradas del objeto "data" y almacenar los valores en el mapa
        for (Map.Entry<String, JsonElement> entry : dataObject.entrySet()) {
            String key = entry.getKey();
            Double value = entry.getValue().getAsDouble();
            keyValuePairs.put(key, value);
        }

        return keyValuePairs;
    }

    /*
    @Override
    public Map<String, Double> load(Currency from) {
        String resultado = ApiReader.load(this.apiUrl);
        if (resultado == null) {
            System.out.println("No se ha podido establecer conexión");
            return null;
        }
        return JSONtoMap(resultado);
    }
    */
    public Map<String,Double> load() {
        String resultado = ApiReader.load(ApiUrlBuilder.defaultUrl());
        if (resultado == null) {
            System.out.println("No se ha podido establecer conexión");
            return null;
        }
        return JSONtoMap(resultado);
    }

    @Override
    public List<ExchangeRate> load(Currency from) {
        return null;
    }
}
