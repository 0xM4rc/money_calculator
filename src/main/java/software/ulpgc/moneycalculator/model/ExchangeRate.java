package software.ulpgc.moneycalculator.model;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, LocalDate date, double rate) {

    // TODO: que sea un hashmap de exchanges y disponga de una funcion para el cambio
}
