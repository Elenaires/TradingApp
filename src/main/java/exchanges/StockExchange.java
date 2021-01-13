package exchanges;

import exceptions.InsufficientUnitsException;
import exceptions.InvalidCodeException;

import java.math.BigDecimal;
import java.util.*;

public interface StockExchange {

    void buy(String code, Integer units) throws InsufficientUnitsException,
            InvalidCodeException;

    void sell(String code, Integer units) throws InvalidCodeException;

    Map<String, Integer> getOrderBookTotalVolume();

    BigDecimal getTradingCosts();
}
