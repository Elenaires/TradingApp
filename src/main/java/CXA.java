import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CXA extends Exchange {

    @Override
    public BigDecimal getCharge() {
        return new BigDecimal("7");
    }

    /*private Map<String, Integer> stocks = new HashMap<>();
    private BigDecimal income = new BigDecimal("0");
    private BigDecimal charge = new BigDecimal("5");

    public CXA() {
        stocks.put("NAB", 0);
        stocks.put("CBA", 0);
        stocks.put("QAN", 0);
    }

    public void buy(String code, Integer units) throws InsufficientUnitsException,
            InvalidCodeException {
        if(!stocks.containsKey(code)) {
            throw new InvalidCodeException("Invalid stock code.");
        }
        if(stocks.get(code) < units) {
            throw new InsufficientUnitsException("Insufficient units.");
        }

        stocks.put(code, stocks.get(code) + units);
        income.add(charge);
    }

    public void sell(String code, Integer units) throws InvalidCodeException {
        if(!stocks.containsKey(code)) {
            throw new InvalidCodeException("Invalid stock code.");
        }
        stocks.put(code, stocks.get(code) - units);
        income.add(charge);
    }

    public Map<String, Integer> getOrderBookTotalVolume() {
        return stocks;
    }

    public BigDecimal getTradingCosts() {
        return income;
    }*/
}
