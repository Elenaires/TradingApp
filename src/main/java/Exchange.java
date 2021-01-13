import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Exchange implements StockExchange {

    private Map<String, Integer> stocks = new HashMap<>();
    private BigDecimal income = new BigDecimal("0");

    public Exchange() {
        stocks.put("NAB", 0);
        stocks.put("CBA", 0);
        stocks.put("QAN", 0);
    }

    protected abstract BigDecimal getCharge();

    public void buy(String code, Integer units) throws InsufficientUnitsException,
            InvalidCodeException {
        if(!stocks.containsKey(code)) {
            throw new InvalidCodeException("Invalid stock code.");
        }
        if(stocks.get(code) < units) {
            throw new InsufficientUnitsException("Insufficient units.");
        }

        stocks.put(code, stocks.get(code) - units);
        income = income.add(getCharge());
    }

    public void sell(String code, Integer units) throws InvalidCodeException {
        if(!stocks.containsKey(code)) {
            throw new InvalidCodeException("Invalid stock code.");
        }
        stocks.put(code, stocks.get(code) + units);
        income = income.add(getCharge());
    }

    public Map<String, Integer> getOrderBookTotalVolume() {
        return stocks;
    }

    public BigDecimal getTradingCosts() {
        return income;
    }
}
