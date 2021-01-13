import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import enums.Stock;
import exceptions.InsufficientUnitsException;
import exceptions.InvalidCodeException;
import exchanges.StockExchange;
import modules.AppModule;
import modules.StockExchangeModule;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;

public class Assignment {

    private StockExchange stockExchange;

    @Inject
    public Assignment(StockExchange exchange) {
        stockExchange = exchange;
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("no input parameter");
            System.exit(1);
        }

        String exchange = args[args.length - 1];

        Injector injector = Guice.createInjector(new AppModule(), new StockExchangeModule(exchange));

        Assignment assignment = injector.getInstance(Assignment.class);
        assignment.trade();
        assignment.displayOutcome();
    }

    public void displayOutcome() {
        Map<String, Integer> remainingStocks = stockExchange.getOrderBookTotalVolume();
        BigDecimal income = stockExchange.getTradingCosts();

        System.out.println("Income is: " + income.toString());
        System.out.println("Remaining stock volume: ");
        for(Map.Entry<String, Integer> entry : remainingStocks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void trade() {
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
    }
}

/**
 Assumptions:
 1) Buying/Selling 0 unit will be treated as a successful transaction and incur a fee
 2) Unsuccessful transactions will not incur a fee
 **/