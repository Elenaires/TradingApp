/*
 *  Class name : Exchange
 *  PURPOSE: Abstract container class for Exchange, implements StockExchange interface
 */

package exchanges;

import exceptions.InsufficientUnitsException;
import exceptions.InvalidCodeException;
import utils.IO;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public abstract class Exchange implements StockExchange {

    // store volume of stocks
    private final Map<String, Integer> stocks = new HashMap<>();
    private BigDecimal income = null;
    private final IO io;

    public Exchange(IO io) {
        this.io = io;
        String exchangeName = getExchangeName();

        // load existing file if exists to restore state from previous execution
        if(exchangeName.equals("ASX")) {
            loadFile("ASX_volume", stocks);
        }
        else {
            loadFile("CXA_volume", stocks);
        }
    }

    /* Get trade charge of exchange */
    protected abstract BigDecimal getCharge();

    /* Get name of exchange */
    protected abstract String getExchangeName();

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
        writeVolumeToFile();
        writeActivityToFile("buy", code, units);
    }

    public void sell(String code, Integer units) throws InvalidCodeException {
        if(!stocks.containsKey(code)) {
            throw new InvalidCodeException("Invalid stock code.");
        }
        stocks.put(code, stocks.get(code) + units);
        income = income.add(getCharge());
        writeVolumeToFile();
        writeActivityToFile("sell", code, units);
    }

    public Map<String, Integer> getOrderBookTotalVolume() {
        return new HashMap<>(stocks);
    }

    public BigDecimal getTradingCosts() {
        return income;
    }

    /* Read the given filename and store state from previous execution */
    private void loadFile(String fileName, Map<String, Integer> stocks) {
        income = io.readFile(fileName, stocks);
    }

    /* Write stock volume to file (exchange_volume) */
    private void writeVolumeToFile() {
        String outString = toString();
        String fileName = getExchangeName() + "_volume";
        io.writeFile(outString, fileName, false);
    }

    /* Write trading activity to file (exchange_logger) */
    private void writeActivityToFile(String trade, String code, int units) {
        String outString = trade + "," + code + "," + units;
        String fileName = getExchangeName() + "_logger";
        io.writeFile(outString, fileName, true);
    }

    /* Return a formatted String with info of current income and stock volume */
    public String toString() {
        StringBuilder sb = new StringBuilder(income.toString() + "\n");
        for(Map.Entry<String, Integer> entry : stocks.entrySet()) {
            sb.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
}
