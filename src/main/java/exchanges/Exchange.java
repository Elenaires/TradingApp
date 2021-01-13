package exchanges;

import exceptions.InsufficientUnitsException;
import exceptions.InvalidCodeException;
import utils.FileIO;
import utils.IO;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Exchange implements StockExchange {

    private final Map<String, Integer> stocks = new HashMap<>();
    private BigDecimal income = null;
    private final IO io;

    public Exchange() {
        io = new FileIO();
        String exchangeName = getExchangeName();
        if(exchangeName.equals("ASX")) {
            loadFile("ASX", stocks);
        }
        else {
            loadFile("CXA", stocks);
        }
    }

    protected abstract BigDecimal getCharge();
    protected abstract String getExchangeName();

    public void buy(String code, Integer units) throws InsufficientUnitsException,
            InvalidCodeException {
        System.out.println("buy " + code + " : " + units);
        if(!stocks.containsKey(code)) {
            throw new InvalidCodeException("Invalid stock code.");
        }
        if(stocks.get(code) < units) {
            throw new InsufficientUnitsException("Insufficient units.");
        }
        stocks.put(code, stocks.get(code) - units);
        income = income.add(getCharge());
        writeFile();
    }

    public void sell(String code, Integer units) throws InvalidCodeException {
        System.out.println("sell " + code + " : " + units);
        if(!stocks.containsKey(code)) {
            throw new InvalidCodeException("Invalid stock code.");
        }
        stocks.put(code, stocks.get(code) + units);
        income = income.add(getCharge());
        writeFile();
    }

    public Map<String, Integer> getOrderBookTotalVolume() {
        return new HashMap<>(stocks);
    }

    public BigDecimal getTradingCosts() {
        return new BigDecimal(income.toString());
    }

    private void loadFile(String fileName, Map<String, Integer> stocks) {
        income = io.readFile(fileName, stocks);
    }

    private void writeFile() {
        String outString = toString();
        System.out.println(outString);
        io.writeFile(outString, getExchangeName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(income.toString() + "\n");
        for(Map.Entry<String, Integer> entry : stocks.entrySet()) {
            sb.append(entry.getKey() + ":" + entry.getValue() + "\n");
        }
        return sb.toString();
    }
}
