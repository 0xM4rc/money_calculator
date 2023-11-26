package software.ulpgc.moneycalculator.api;

import java.io.InputStream;
import java.net.URL;

public class ApiReader {

    public static String load(String url) {
        try (InputStream is =new URL(url).openStream()) {
            return new String(is.readAllBytes());
        } catch (Exception e) {
            return null;
        }
    }
}
