import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.sun.xml.internal.ws.server.DefaultResourceInjector;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

public class Assignment {
    public static void main(String[] args) {

        String exchange = args[args.length - 1];
        StockExchange stockExchange = null;
        Injector injector = Guice.createInjector();
        /* Injector injector = Guice.createInjector();

        Assignment assignment = injector.getInstance(Assignment.class);*/

        if(exchange.equals("ASX")) {
           // stockExchange = injector.getInstance(Key.get(StockExchange.class, ASX.class));
            stockExchange = new ASX();
        }
        else if(exchange.equals("CXA")) {
          //  stockExchange = injector.getInstance(Key.get(StockExchange.class, CXA.class));
            stockExchange = new CXA();
        }

        trade(stockExchange);
    }

    public static void trade(StockExchange stockExchange) {
        Random rnd = new Random();
        int numTimes = /*rnd.nextInt(10);*/ 10;
        boolean buy = false;
        int numUnits = 0;
        String stock = "";

        for(int i = 0; i < numTimes; i++) {
            buy = rnd.nextBoolean();
            numUnits = rnd.nextInt(10);
            stock = Stock.getRandomStock().getName();

            if(buy) {
                try {
                    stockExchange.buy(stock, numUnits);
                }
                catch (InsufficientUnitsException | InvalidCodeException e) {
                    System.out.println(e.getMessage());
                }

            }
            else {
                try {
                    stockExchange.sell(stock, numUnits);
                }
                catch (InvalidCodeException e){
                    System.out.println(e.getMessage());
                }
            }
        }

        Map<String, Integer> remainingStocks = stockExchange.getOrderBookTotalVolume();
        BigDecimal income = stockExchange.getTradingCosts();

        System.out.println("Income is: " + income.toString());
        System.out.println("Remaining stock volume: ");
        for(Map.Entry<String, Integer> entry : remainingStocks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

/**
 Assumptions:
 1) Buying/Selling 0 unit will be treated as a successful transaction and incur a fee
 2) Unsuccessful transactions will not incur a fee
 **/